package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.service.*;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final ReferralService referralService;
    private final AppointmentCheckUpService appointmentCheckUpService;

    public AppointmentController(AppointmentService appointmentService,
                                 PatientService patientService,
                                 ReferralService referralService,
                                 AppointmentCheckUpService appointmentCheckUpService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.referralService = referralService;
        this.appointmentCheckUpService = appointmentCheckUpService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailableAppointmentDTO>> getAppointments() {
        List<Appointment> availableAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<AvailableAppointmentDTO>> getAvailableAppointments(
            @RequestParam(name = "medicalServiceId", required = true) Long medicalServiceId,
            @RequestParam(name = "doctorId", required = false) Long doctorId,
            @RequestParam(name = "dateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam(name = "dateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo,
            @RequestParam(name = "language", required = true) Doctor.Language language) {
        AvailableAppointmentsRequestDTO aarDTO = new AvailableAppointmentsRequestDTO(medicalServiceId,doctorId,dateFrom,dateTo,language);
        List<Appointment> availableAppointments = appointmentService.getAvailableAppointments(aarDTO);
        return ResponseEntity.ok(availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientsDoneVisitDTO> getAppointmentById(@PathVariable long id){
        return ResponseEntity.ok(new PatientsDoneVisitDTO(appointmentService.getAppointmentById(id)));
    }

    @GetMapping("/diagnosticTests")
    public ResponseEntity<AppointmentCheckUpDTO> getAppointmentCheckUpById(@PathVariable long appointmentId, @PathVariable long checkUpId){
        return ResponseEntity.ok(new AppointmentCheckUpDTO(appointmentCheckUpService.getAppointmentCheckUp(appointmentId,checkUpId)));
    }

    @PostMapping
    public ResponseEntity<AvailableAppointmentDTO> addAppointment(@Valid @RequestBody CreateAppointmentDTO createAppointmentDTO) {
        Appointment createdAppointment = appointmentService.saveAppointment(createAppointmentDTO);
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdAppointment.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id){
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok("Success");
    }

    //TODO: check if validation works
    @PatchMapping("{id}/reserve")
    public ResponseEntity<Void> reserveAppointment(@PathVariable("id") long id,
                                                   @Valid @RequestBody PatchAppointmentDTO patchAppointmentDTO) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        JsonNullable<Long> patientId = patchAppointmentDTO.getPatientId();
        if (patientId.isPresent()) {
            Patient patient = patientService.getPatientById(patientId.get());
            appointment.setPatient(patient);
        }

        JsonNullable<Long> referralId = patchAppointmentDTO.getReferralId();
        if (referralId.isPresent()) {
            Referral referral = referralService.getReferralById(referralId.get());
            appointment.setReferral(referral);
        }

        LocalDate appointmentDate = appointment.getDate().toLocalDate();
        if (LocalDate.now().isEqual(appointmentDate)) {
            appointment.setState(Appointment.AppointmentState.CONFIRMED);
        } else {
            appointment.setState(Appointment.AppointmentState.RESERVED);
        }

        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/confirm")
    public ResponseEntity<Void> confirmAppointment(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        appointment.setState(Appointment.AppointmentState.CONFIRMED);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        if(appointment.getState().equals(Appointment.AppointmentState.CONFIRMED)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment confirmed- cannot cancel");
        }
        if (appointment.getReferral() != null) {
            appointment.setReferral(null);
        }
        if (appointment.getPatient() != null) {
            appointment.setPatient(null);
        }

        appointment.setState(Appointment.AppointmentState.AVAILABLE);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{appointmentId}/testResult/{checkUpId}")
    public ResponseEntity<Void> addCheckupResult(@PathVariable("appointmentId") long appointmentId,
                                                 @PathVariable("appointmentId") long checkUpId,
                                                 @Valid @RequestBody PatchAppointmentCheckUpDTO patchAppointmentCheckUpDTO) {

        AppointmentCheckUp appointmentCheckUp = appointmentCheckUpService.getAppointmentCheckUp(appointmentId,checkUpId);

        appointmentCheckUp.setResult(patchAppointmentCheckUpDTO.getResult().get());
        appointmentCheckUp.setFile(patchAppointmentCheckUpDTO.getFile().get());
        if (Objects.nonNull(patchAppointmentCheckUpDTO.getDoctorsDescription().get())) {
            appointmentCheckUp.setDoctorsDescription(patchAppointmentCheckUpDTO.getDoctorsDescription().get());
        }

        appointmentCheckUpService.saveAppointmentCheckUp(appointmentCheckUp);
        return ResponseEntity.noContent().build();
    }


}
