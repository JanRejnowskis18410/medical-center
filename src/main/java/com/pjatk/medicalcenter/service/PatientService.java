package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Address;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.model.Person;
import com.pjatk.medicalcenter.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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

    public Patient getPatientById(long id){
       return patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient does not exists"));
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        if(patientRepository.findById(patient.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient does not exists")) != null)
            return patientRepository.save(patient);

        return null;
    }

    public void deletePatientById(long id){
        patientRepository.delete(patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient does not exists")));
    }

}
