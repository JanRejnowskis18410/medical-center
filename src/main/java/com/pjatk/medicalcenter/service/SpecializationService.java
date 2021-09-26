package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Specialization;
import com.pjatk.medicalcenter.repository.SpecializationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<Specialization> getSpecializations(){
        return specializationRepository.findAll();
    }

    public Specialization getSpecializationById(long id){
        return specializationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Specialization does not exists"));
    }

    public Specialization addSpecialization(Specialization specialization){
        return specializationRepository.save(specialization);
    }

    public Specialization updateSpecialization(Specialization specialization){
        if(specializationRepository.findById(specialization.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists")) != null)
            return specializationRepository.save(specialization);

        return null;
    }

    public void deleteSpecializationById(long id){
        specializationRepository.delete(specializationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Specialization does not exists")));
    }
}
