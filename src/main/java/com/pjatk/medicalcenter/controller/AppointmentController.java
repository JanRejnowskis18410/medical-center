package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.service.*;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentCheckUpService appointmentCheckUpService;

    public AppointmentController(AppointmentService appointmentService, AppointmentCheckUpService appointmentCheckUpService) {
        this.appointmentService = appointmentService;
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
                @RequestParam(name = "size", defaultValue = "10") int size) {

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
                                                   @Valid @RequestBody ReserveAppointmentDTO reserveAppointmentDTO) {
        appointmentService.reserveAppointment(id, reserveAppointmentDTO);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/confirm")
    public ResponseEntity<Void> confirmAppointment(@PathVariable("id") long id, Authentication auth) {
        appointmentService.confirmAppointment(id, auth);
        return ResponseEntity.noContent().build();
    }

    //pacjent walidacja id
    @PatchMapping("{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") long id, Authentication auth) {
        appointmentService.cancelAppointment(id, auth);
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
