package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(long id){
        return doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor does not exists"));
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor){
        if(doctorRepository.findById(doctor.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists")) != null)
            return doctorRepository.save(doctor);

        return null;
    }

    public void deleteDoctorById(long id){
        doctorRepository.delete(doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor does not exists")));
    }
}
