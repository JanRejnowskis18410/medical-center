package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AppointmentDTO;
import com.pjatk.medicalcenter.dto.CreateAppointmentDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Service;
import com.pjatk.medicalcenter.service.AppointmentService;
import com.pjatk.medicalcenter.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final ServiceService serviceService;

    public AppointmentController(AppointmentService appointmentService, ServiceService serviceService) {
        this.appointmentService = appointmentService;
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAvailableAppointments() {
        List<Appointment> availableAppointments = appointmentService.getAvailableAppointments();
        return ResponseEntity.ok(availableAppointments.stream().map(AppointmentDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        Appointment createdAppointment = appointmentService.addAppointment(mapCreateAppointmentDTOToAppointment(createAppointmentDTO));
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdAppointment.getId()))).build();
    }

    private Appointment mapCreateAppointmentDTOToAppointment(CreateAppointmentDTO createAppointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(createAppointmentDTO.getId());
        appointment.setType(createAppointmentDTO.getType());
        appointment.setDate(createAppointmentDTO.getDate());

        Service service = serviceService.getServiceById(createAppointmentDTO.getServiceId());
        appointment.setService(service);
        appointment.setConfirmed(false);

        return appointment;
    }
}
