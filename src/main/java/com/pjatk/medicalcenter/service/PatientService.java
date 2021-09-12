package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients(){
       return patientRepository.findAll();
    }
}
