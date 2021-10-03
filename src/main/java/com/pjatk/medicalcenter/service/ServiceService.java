package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.repository.ServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.pjatk.medicalcenter.model.Service> getServices() {
        return serviceRepository.findAll();
    }

    public com.pjatk.medicalcenter.model.Service getServiceById(long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exist"));
    }
}
