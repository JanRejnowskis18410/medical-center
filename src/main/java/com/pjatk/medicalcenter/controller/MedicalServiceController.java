package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.ServiceDTO;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.service.MedicalServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class MedicalServiceController {

    private final MedicalServiceService medicalServiceService;

    public MedicalServiceController(MedicalServiceService medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getServices() {
        List<MedicalService> medicalServices = medicalServiceService.getServices();
        return ResponseEntity.ok(medicalServices.stream().map(ServiceDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable long id) {
        return ResponseEntity.ok(new ServiceDTO(medicalServiceService.getServiceById(id)));
    }

    @PostMapping
    public ResponseEntity<MedicalService> addService(@RequestBody ServiceDTO serviceDTO) {
        MedicalService createdMedicalService = medicalServiceService.addService(mapServiceDTOToService(serviceDTO));
        return ResponseEntity.created(URI.create(String.format("/services/%d", createdMedicalService.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<MedicalService> updateService(@RequestBody ServiceDTO serviceDTO) {
        MedicalService updatedMedicalService = medicalServiceService.updateService(mapServiceDTOToService(serviceDTO));
        return ResponseEntity.created(URI.create(String.format("/services/%d", updatedMedicalService.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable long id) {
        medicalServiceService.deletePatientById(id);
        return ResponseEntity.ok("Success");
    }


    MedicalService mapServiceDTOToService(ServiceDTO serviceDTO) {
        MedicalService medicalService = new MedicalService();
        medicalService.setId(serviceDTO.getId());
        medicalService.setName(serviceDTO.getName());

        return medicalService;
    }
}
