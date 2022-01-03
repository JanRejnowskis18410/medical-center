package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.MedicalServiceDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.model.Specialization;
import com.pjatk.medicalcenter.repository.MedicalServiceRepository;
import com.pjatk.medicalcenter.repository.SpecializationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.pjatk.medicalcenter.util.ErrorMessages.SERVICE_NOT_FOUND_ERROR_MESS;
import static com.pjatk.medicalcenter.util.ErrorMessages.SPECIALIZATION_NOT_FOUND_ERROR_MESS;

@Service
public class MedicalServiceService {

    private final MedicalServiceRepository medicalServiceRepository;
    private final SpecializationRepository specializationRepository;

    public MedicalServiceService(MedicalServiceRepository medicalServiceRepository, SpecializationRepository specializationRepository) {
        this.medicalServiceRepository = medicalServiceRepository;
        this.specializationRepository = specializationRepository;
    }

    public List<MedicalService> getServices() {
        return medicalServiceRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<MedicalService> getServicesByAppointmentType(Appointment.AppointmentType appointmentType) {
        return appointmentType.equals(Appointment.AppointmentType.FACILITY) ?
                medicalServiceRepository.findMedicalServicesByFacilityServiceIsTrueOrderByNameAsc() :
                medicalServiceRepository.findMedicalServicesByFacilityServiceIsFalseOrderByNameAsc();
    }

    public MedicalService getServiceById(long id) {
        return medicalServiceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, SERVICE_NOT_FOUND_ERROR_MESS));
    }

    public MedicalService addMedicalService(MedicalService medicalService, long specializationId) {

        Specialization specialization = specializationRepository.findById(specializationId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, SPECIALIZATION_NOT_FOUND_ERROR_MESS));

        medicalService.setSpecialization(specialization);
        return medicalServiceRepository.save(medicalService);
    }

    public MedicalService updateService(MedicalService medicalService) {
        if(medicalServiceRepository.findById(medicalService.getId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, SERVICE_NOT_FOUND_ERROR_MESS)) != null)
            return medicalServiceRepository.save(medicalService);

        return null;
    }

    public void deletePatientById(long id) {
        medicalServiceRepository.delete(medicalServiceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, SERVICE_NOT_FOUND_ERROR_MESS)));
    }
}
