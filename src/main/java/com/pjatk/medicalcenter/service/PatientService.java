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
       return patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Patient addPatient(Patient patient){
        Address address = new Address("aa","bb","a","a","poland");

      //  Patient patient1 = new Patient(new Person("ola","lola","ola@gmial.com", LocalDate.now(),"199219191919"),address,"908162812");
        return patientRepository.save(patient);
    }

    public void updatePatient(Patient patient){
        if(patientRepository.findById(patient.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)) != null)
            patientRepository.save(patient);
    }

    public void deletePatientById(long id){
        patientRepository.delete(patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

}
