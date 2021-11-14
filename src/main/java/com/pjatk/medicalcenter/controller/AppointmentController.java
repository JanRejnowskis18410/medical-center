package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AppointmentDTO;
import com.pjatk.medicalcenter.dto.AvailableAppointmentsRequestDTO;
import com.pjatk.medicalcenter.dto.CreateAppointmentDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.service.AppointmentService;
import com.pjatk.medicalcenter.service.MedicalServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final MedicalServiceService medicalServiceService;

    public AppointmentController(AppointmentService appointmentService, MedicalServiceService medicalServiceService) {
        this.appointmentService = appointmentService;
        this.medicalServiceService = medicalServiceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDTO>> getAppointments() {
        List<Appointment> availableAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(availableAppointments.stream().map(AppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAvailableAppointments(@RequestBody AvailableAppointmentsRequestDTO availableAppointmentsRq) {
        List<Appointment> availableAppointments = appointmentService.getAvailableAppointments(availableAppointmentsRq);
        return ResponseEntity.ok(availableAppointments.stream().map(AppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable long id){
        return ResponseEntity.ok(new AppointmentDTO(appointmentService.getAppointmentById(id)));
    }

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        Appointment createdAppointment = appointmentService.addAppointment(createAppointmentDTO);
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdAppointment.getId()))).build();
    }

    @PostMapping("/addList")
    public ResponseEntity<Appointment> addAppointments(@RequestBody List<CreateAppointmentDTO> createAppointmentDTOs) {
        List<Appointment> createdAppointments = appointmentService.addAppointments(createAppointmentDTOs);
        return ResponseEntity.created(URI.create(String.format("/appointments/"))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id){
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok("Success");
    }
}
