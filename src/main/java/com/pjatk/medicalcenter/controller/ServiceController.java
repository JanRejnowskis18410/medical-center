package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.ServiceDTO;
import com.pjatk.medicalcenter.model.Service;
import com.pjatk.medicalcenter.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getServices() {
        List<Service> services = serviceService.getServices();
        return ResponseEntity.ok(services.stream().map(ServiceDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable long id) {
        return ResponseEntity.ok(new ServiceDTO(serviceService.getServiceById(id)));
    }

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody ServiceDTO serviceDTO) {
        Service createdService = serviceService.addService(mapServiceDTOToService(serviceDTO));
        return ResponseEntity.created(URI.create(String.format("/services/%d", createdService.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Service> updateService(@RequestBody ServiceDTO serviceDTO) {
        Service updatedService = serviceService.updateService(mapServiceDTOToService(serviceDTO));
        return ResponseEntity.created(URI.create(String.format("/services/%d", updatedService.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable long id) {
        serviceService.deletePatientById(id);
        return ResponseEntity.ok("Success");
    }


    Service mapServiceDTOToService(ServiceDTO serviceDTO) {
        Service service = new Service();
        service.setId(serviceDTO.getId());
        service.setName(serviceDTO.getName());

        return service;
    }
}
