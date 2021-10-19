package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AppointmentDTO;
import com.pjatk.medicalcenter.dto.CreateAppointmentDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
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
    public ResponseEntity<List<AppointmentDTO>> getAvailableAppointments(@RequestParam(name = "type") Appointment.AppointmentType appointmentType) {
        List<Appointment> availableAppointments = appointmentService.getAvailableAppointments(appointmentType);
        return ResponseEntity.ok(availableAppointments.stream().map(AppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable long id){
        return ResponseEntity.ok(new AppointmentDTO(appointmentService.getAppointmentById(id)));
    }

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        Appointment createdAppointment = appointmentService.addAppointment(mapCreateAppointmentDTOToAppointment(createAppointmentDTO));
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdAppointment.getId()))).build();
    }

    @PostMapping("/addList")
    public ResponseEntity<Appointment> addAppointments(@RequestBody List<CreateAppointmentDTO> createAppointmentDTOs) {
        List<Appointment> createdAppointments = appointmentService.addAppointments(createAppointmentDTOs.stream().map(this::mapCreateAppointmentDTOToAppointment).collect(Collectors.toList()));
        return ResponseEntity.created(URI.create(String.format("/appointments/"))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id){
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok("Success");
    }

    private Appointment mapCreateAppointmentDTOToAppointment(CreateAppointmentDTO createAppointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(createAppointmentDTO.getId());
        appointment.setType(createAppointmentDTO.getType());
        appointment.setDate(createAppointmentDTO.getDate());

        MedicalService medicalService = serviceService.getServiceById(createAppointmentDTO.getServiceId());
        appointment.setMedicalService(medicalService);
        appointment.setConfirmed(false);

        return appointment;
    }
}
