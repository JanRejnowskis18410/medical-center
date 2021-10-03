package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.repository.ServiceRepository;
import org.springframework.stereotype.Service;

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
}
