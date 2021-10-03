package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.PatientDTO;
import com.pjatk.medicalcenter.dto.ServiceDTO;
import com.pjatk.medicalcenter.model.Service;
import com.pjatk.medicalcenter.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable long id){
        return ResponseEntity.ok(new ServiceDTO(serviceService.getServiceById(id)));
    }
}
