package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.CreateMedicalServiceDTO;
import com.pjatk.medicalcenter.dto.MedicalServiceDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.service.MedicalServiceService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicalServices")
public class MedicalServiceController {

    private final MedicalServiceService medicalServiceService;

    public MedicalServiceController(MedicalServiceService medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalServiceDTO> getServiceById(@PathVariable long id) {
        return ResponseEntity.ok(new MedicalServiceDTO(medicalServiceService.getServiceById(id)));
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<MedicalServiceDTO>> getServices(@RequestParam(name = "type", required = false) Appointment.AppointmentType appointmentType) {
        if(appointmentType != null)
            return ResponseEntity.ok(medicalServiceService.getServicesByAppointmentType(appointmentType).stream()
                .map(MedicalServiceDTO::new).collect(Collectors.toList()));
        else
            return ResponseEntity.ok(medicalServiceService.getServices().stream()
                    .map(MedicalServiceDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<MedicalService> addService(@RequestBody CreateMedicalServiceDTO createMedicalServiceDTO) {
        MedicalService createdMedicalService = medicalServiceService
                .addMedicalService(DTOsMapper.mapCreateServiceDTOToService(createMedicalServiceDTO),createMedicalServiceDTO.getSpecializationId());
        return ResponseEntity.created(URI.create(String.format("/services/%d", createdMedicalService.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<MedicalService> updateService(@RequestBody MedicalServiceDTO medicalServiceDTO) {
        MedicalService updatedMedicalService = medicalServiceService.updateService(DTOsMapper.mapServiceDTOToService(medicalServiceDTO));
        return ResponseEntity.created(URI.create(String.format("/services/%d", updatedMedicalService.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable long id) {
        medicalServiceService.deletePatientById(id);
        return ResponseEntity.ok("Success");
    }
}
