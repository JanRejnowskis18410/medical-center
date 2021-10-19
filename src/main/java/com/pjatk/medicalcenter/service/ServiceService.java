package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.MedicalService;
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

    public List<MedicalService> getServices() {
        return serviceRepository.findAll();
    }

    public MedicalService getServiceById(long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exist"));
    }

    public MedicalService addService(MedicalService medicalService) {
        return serviceRepository.save(medicalService);
    }

    public MedicalService updateService(MedicalService medicalService) {
        if(serviceRepository.findById(medicalService.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exists")) != null)
            return serviceRepository.save(medicalService);

        return null;
    }

    public void deletePatientById(long id) {
        serviceRepository.delete(serviceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exist")));
    }
}
