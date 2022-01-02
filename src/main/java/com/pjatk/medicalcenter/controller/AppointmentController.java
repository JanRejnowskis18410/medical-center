package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.service.*;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final ReferralService referralService;
    private final AppointmentCheckUpService appointmentCheckUpService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService,
                                 ReferralService referralService, AppointmentCheckUpService appointmentCheckUpService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.referralService = referralService;
        this.appointmentCheckUpService = appointmentCheckUpService;
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAvailableAppointments(
                @RequestParam(name = "medicalServiceId", required = true) Long medicalServiceId,
                @RequestParam(name = "doctorId", required = false) Long doctorId,
                @RequestParam(name = "dateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                @RequestParam(name = "dateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo,
                @RequestParam(name = "language", required = true) Doctor.Language language,
                @RequestParam(name = "page", defaultValue = "0") int page,
                @RequestParam(name = "size", defaultValue = "1") int size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("date").ascending());
        AvailableAppointmentsRequestDTO aarDTO = new AvailableAppointmentsRequestDTO(medicalServiceId,doctorId,dateFrom,dateTo,language);
        Page<Appointment> availableAppointments = appointmentService.getAvailableAppointments(aarDTO, paging);

        Map<String,Object> response = new HashMap<>();
        response.put("appointments", availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
        response.put("currentPage", availableAppointments.getNumber());
        response.put("totalItems", availableAppointments.getTotalElements());
        response.put("totalPages", availableAppointments.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/diagnosticTests")
    public ResponseEntity<AppointmentCheckUpDTO> getAppointmentCheckUpById (
            @RequestParam("appointmentId") long appointmentId,
            @RequestParam("checkUpId") long checkUpId,
            Authentication auth){
        return ResponseEntity.ok(
                new AppointmentCheckUpDTO(appointmentCheckUpService.getAppointmentCheckUp(appointmentId,checkUpId, auth, AppRole.PATIENT))
        );
    }

    @PatchMapping("{id}/reserve")
    public ResponseEntity<Void> reserveAppointment(@PathVariable("id") long id,
                                                   @Valid @RequestBody ConfirmAppointmentDTO confirmAppointmentDTO) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        JsonNullable<Long> patientId = confirmAppointmentDTO.getPatientId();
        if (patientId.isPresent()) {
            Patient patient = patientService.getPatientById(patientId.get());
            appointment.setPatient(patient);
        }

        JsonNullable<Long> referralId = confirmAppointmentDTO.getReferralId();
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
    public ResponseEntity<Void> confirmAppointment(@PathVariable("id") long id, Authentication auth) {
        appointmentService.confirmAppointment(id, auth);
        return ResponseEntity.noContent().build();
    }

    //pacjent walidacja id
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
                                                 @PathVariable("checkUpId") long checkUpId,
                                                 @Valid @RequestBody AddCheckUpResultDTO addCheckupResultDTO,
                                                 Authentication auth) {

       appointmentService.addCheckupResult(appointmentId, checkUpId, addCheckupResultDTO, auth);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/done")
    public ResponseEntity<Void> doneAppointment(@PathVariable("id") long id,
                                                @Valid @RequestBody DoneAppointmentDTO doneAppointmentDTO,
                                                Authentication auth) {
        appointmentService.endVisit(id, doneAppointmentDTO, auth);
        return ResponseEntity.noContent().build();
    }

}
