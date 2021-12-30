package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.MedicalServiceDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.service.MedicalServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicalServices")
@CrossOrigin
public class MedicalServiceController {

    private final MedicalServiceService medicalServiceService;

    public MedicalServiceController(MedicalServiceService medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    @GetMapping()
    public ResponseEntity<List<MedicalServiceDTO>> getServices(@RequestParam(name = "type", required = false) Appointment.AppointmentType appointmentType) {
        if(appointmentType != null)
            return ResponseEntity.ok(medicalServiceService.getServicesByAppointmentType(appointmentType).stream()
                .map(MedicalServiceDTO::new).collect(Collectors.toList()));
        else
            return ResponseEntity.ok(medicalServiceService.getServices().stream()
                    .map(MedicalServiceDTO::new).collect(Collectors.toList()));
    }
}
