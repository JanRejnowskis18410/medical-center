package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.AddSpecializationWithScheduleDTO;
import com.pjatk.medicalcenter.dto.SpecializationDTO;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.DoctorSpecialization;
import com.pjatk.medicalcenter.model.Specialization;
import com.pjatk.medicalcenter.repository.DoctorRepository;
import com.pjatk.medicalcenter.repository.DoctorSpecializationRepository;
import com.pjatk.medicalcenter.repository.SpecializationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;
    private final SpecializationRepository specializationRepository;

    public DoctorService(DoctorRepository doctorRepository, DoctorSpecializationRepository doctorSpecializationRepository, SpecializationRepository specializationRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorSpecializationRepository = doctorSpecializationRepository;
        this.specializationRepository = specializationRepository;
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

    //TODO czy to dziala
    public Doctor addDoctorSpecializationWithSchedule(long doctorId, AddSpecializationWithScheduleDTO addSpecializationWithScheduleDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        Specialization specialization = specializationRepository.findById(addSpecializationWithScheduleDTO.getSpecializationId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists"));
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
        doctorSpecialization.setSpecialization(specialization);
        doctorSpecialization.setDoctor(doctor);
        if(addSpecializationWithScheduleDTO.getSchedules() != null && addSpecializationWithScheduleDTO.getSchedules().size() > 0)
            doctorSpecialization.addSchedule(addSpecializationWithScheduleDTO.getSchedules());
        doctorSpecializationRepository.save(doctorSpecialization);

        return doctor;
    }

    public List<SpecializationDTO> getDoctorSpecializations(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        List<SpecializationDTO> specializationDTOs = new ArrayList<>();
        doctor.getDoctorSpecializations().forEach(e -> specializationDTOs.add(new SpecializationDTO(e.getSpecialization())));

        return specializationDTOs;
    }
}
