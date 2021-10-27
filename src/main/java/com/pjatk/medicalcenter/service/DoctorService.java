package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.SpecializationWithScheduleRequestDTO;
import com.pjatk.medicalcenter.dto.SpecializationWithSchedulesDTO;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.*;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;
    private final SpecializationRepository specializationRepository;
    private final ScheduleRepository scheduleRepository;
    private final MedicalServiceRepository medicalServiceRepository;

    public DoctorService(DoctorRepository doctorRepository, DoctorSpecializationRepository doctorSpecializationRepository, SpecializationRepository specializationRepository, ScheduleRepository scheduleRepository, MedicalServiceRepository medicalServiceRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorSpecializationRepository = doctorSpecializationRepository;
        this.specializationRepository = specializationRepository;
        this.scheduleRepository = scheduleRepository;
        this.medicalServiceRepository = medicalServiceRepository;
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

    public Doctor addDoctorSpecializationWithSchedule(long doctorId, SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        Specialization specialization = specializationRepository
                .findById(specializationWithScheduleRequestDTO.getSpecializationId()).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists"));
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
        doctorSpecialization.setSpecialization(specialization);
        doctorSpecialization.setDoctor(doctor);
        doctorSpecializationRepository.save(doctorSpecialization);
        if(specializationWithScheduleRequestDTO.getSchedules() != null && specializationWithScheduleRequestDTO.getSchedules().size() > 0) {
            doctorSpecialization.addSchedules(specializationWithScheduleRequestDTO.getSchedules().stream().map(DTOsMapper::mapScheduleDTOtoSchedule).collect(Collectors.toList()));
            scheduleRepository.saveAll(doctorSpecialization.getSchedules());
        }
        doctorSpecializationRepository.save(doctorSpecialization);

        return doctor;
    }

    public Doctor deleteDoctorSpecializationSchedules(long doctorId, SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        Specialization specialization = specializationRepository.findById(specializationWithScheduleRequestDTO.getSpecializationId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists"));

        DoctorSpecialization foundSpecializationForThisDoctor = doctor.getDoctorSpecializations().stream()
                .filter(docSpec -> docSpec.getSpecialization().getId() == specialization.getId())
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Specialization with id %s does not exists for doctor for id %s", specializationWithScheduleRequestDTO.getSpecializationId(),doctorId)));

        List<Schedule> schedules = specializationWithScheduleRequestDTO.getSchedules().stream().map(DTOsMapper::mapScheduleDTOtoSchedule).collect(Collectors.toList());
        for(Schedule schedule: schedules)
            scheduleRepository.delete(schedule);


        return doctor;
    }

    public List<SpecializationWithSchedulesDTO> getDoctorSpecializations(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        List<SpecializationWithSchedulesDTO> specializationWithSchedulesDTOS = new ArrayList<>();
        doctor.getDoctorSpecializations().forEach(docSpec ->
                specializationWithSchedulesDTOS.add(new SpecializationWithSchedulesDTO(docSpec)));

        return specializationWithSchedulesDTOS;
    }

    public List<Doctor> getDoctorsByMedicalServiceId(long serviceId) {
        MedicalService medicalService = medicalServiceRepository.findById(serviceId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exists"));
        return doctorRepository.findDoctorsByMedicalServiceId(serviceId);
    }
}
