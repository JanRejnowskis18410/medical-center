package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.MedicalServiceDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.model.Specialization;
import com.pjatk.medicalcenter.repository.MedicalServiceRepository;
import com.pjatk.medicalcenter.repository.SpecializationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicalServiceService {

    private final MedicalServiceRepository medicalServiceRepository;
    private final SpecializationRepository specializationRepository;

    public MedicalServiceService(MedicalServiceRepository medicalServiceRepository, SpecializationRepository specializationRepository) {
        this.medicalServiceRepository = medicalServiceRepository;
        this.specializationRepository = specializationRepository;
    }

    public List<MedicalService> getServices() {
        return medicalServiceRepository.findAll();
    }

    public List<MedicalService> getServicesByAppointmentType(Appointment.AppointmentType appointmentType) {
        return appointmentType.equals(Appointment.AppointmentType.FACILITY) ?
                medicalServiceRepository.findMedicalServicesByFacilityServiceIsTrue() :
                medicalServiceRepository.findMedicalServicesByFacilityServiceIsFalse();
    }

    public MedicalService getServiceById(long id) {
        return medicalServiceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exist"));
    }

    public MedicalService addMedicalService(MedicalService medicalService, long specializationId) {

        Specialization specialization = specializationRepository.findById(specializationId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists"));

        medicalService.setSpecialization(specialization);
        return medicalServiceRepository.save(medicalService);
    }

    public MedicalService updateService(MedicalService medicalService) {
        if(medicalServiceRepository.findById(medicalService.getId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exists")) != null)
            return medicalServiceRepository.save(medicalService);

        return null;
    }

    public void deletePatientById(long id) {
        medicalServiceRepository.delete(medicalServiceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exist")));
    }
}
