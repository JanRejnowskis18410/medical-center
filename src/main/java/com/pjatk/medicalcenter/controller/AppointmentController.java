package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AvailableAppointmentDTO;
import com.pjatk.medicalcenter.dto.AvailableAppointmentsRequestDTO;
import com.pjatk.medicalcenter.dto.CreateAppointmentDTO;
import com.pjatk.medicalcenter.dto.PatchAppointmentDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.model.Referral;
import com.pjatk.medicalcenter.service.AppointmentService;
import com.pjatk.medicalcenter.service.MedicalServiceService;
import com.pjatk.medicalcenter.service.PatientService;
import com.pjatk.medicalcenter.service.ReferralService;
import jakarta.validation.Valid;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final MedicalServiceService medicalServiceService;
    private final PatientService patientService;
    private final ReferralService referralService;

    public AppointmentController(AppointmentService appointmentService, MedicalServiceService medicalServiceService, PatientService patientService, ReferralService referralService) {
        this.appointmentService = appointmentService;
        this.medicalServiceService = medicalServiceService;
        this.patientService = patientService;
        this.referralService = referralService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailableAppointmentDTO>> getAppointments() {
        List<Appointment> availableAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<AvailableAppointmentDTO>> getAvailableAppointments(@RequestBody AvailableAppointmentsRequestDTO availableAppointmentsRq) {
        List<Appointment> availableAppointments = appointmentService.getAvailableAppointments(availableAppointmentsRq);
        return ResponseEntity.ok(availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailableAppointmentDTO> getAppointmentById(@PathVariable long id){
        return ResponseEntity.ok(new AvailableAppointmentDTO(appointmentService.getAppointmentById(id)));
    }

    @PostMapping
    public ResponseEntity<AvailableAppointmentDTO> addAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        Appointment createdAppointment = appointmentService.addAppointment(createAppointmentDTO);
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdAppointment.getId()))).build();
    }

    @PostMapping("/addList")
    public ResponseEntity<AvailableAppointmentDTO> addAppointments(@RequestBody List<CreateAppointmentDTO> createAppointmentDTOs) {
        List<Appointment> createdAppointments = appointmentService.addAppointments(createAppointmentDTOs);
        return ResponseEntity.created(URI.create(String.format("/appointments/"))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id){
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok("Success");
    }

    //TODO: Validation does not work
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
            appointment.setConfirmed(true);
        }

        appointmentService.addAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/confirm")
    public ResponseEntity<Void> confirmAppointment(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        appointment.setConfirmed(true);
        appointmentService.addAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        if (appointment.getReferral() != null) {
            appointment.setReferral(null);
        }
        if (appointment.getPatient() != null) {
            appointment.setPatient(null);
        }

        appointmentService.addAppointment(appointment);
        return ResponseEntity.noContent().build();
    }
}
