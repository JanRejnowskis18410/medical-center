package com.pjatk.medicalcenter.util;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.DoctorSpecialization;
import com.pjatk.medicalcenter.model.Schedule;
import com.pjatk.medicalcenter.model.Specialization;

import java.util.stream.Collectors;

public class DTOsMapper {

    public static Doctor mapDoctorWithSpecializationDTOtoDoctor(DoctorWithSpecializationDTO doctorWithSpecializationDTO){
        Doctor doctor = new Doctor();
        doctor.setId(doctorWithSpecializationDTO.getId());
        doctor.setFirstName(doctorWithSpecializationDTO.getFirstName());
        doctor.setLastName(doctorWithSpecializationDTO.getLastName());
        doctor.setEmail(doctorWithSpecializationDTO.getEmail());
        doctor.setBirthDate(doctorWithSpecializationDTO.getBirthDate());
        doctor.setPesel(doctorWithSpecializationDTO.getPesel());
        doctor.setPWZ(doctorWithSpecializationDTO.getPWZ());
        doctor.setDoctorSpecializations(doctorWithSpecializationDTO.getDoctorSpecializations().stream().map(DTOsMapper::mapDoctorSpecializationDTOtoDoctorSpecialization).collect(Collectors.toList()));

        return doctor;
    }

    public static Doctor mapDoctorDTOtoDoctor(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setBirthDate(doctorDTO.getBirthDate());
        doctor.setPesel(doctorDTO.getPesel());
        doctor.setPWZ(doctorDTO.getPWZ());

        return doctor;
    }

    public static Specialization mapSpecializationWithDoctorsDTOtoSpecialization(SpecializationWithDoctorsDTO specializationWithDoctorsDTO) {
        Specialization specialization = new Specialization();
        specialization.setId(specializationWithDoctorsDTO.getId());
        specialization.setName(specializationWithDoctorsDTO.getName());
        specialization.setDoctorSpecializations(specializationWithDoctorsDTO.getDoctorSpecializations().stream().map(DTOsMapper::mapDoctorSpecializationDTOtoDoctorSpecialization).collect(Collectors.toList()));

        return specialization;
    }

    public static Specialization mapSpecializationDTOtoSpecialization(SpecializationDTO specializationDTO) {
        Specialization specialization = new Specialization();
        specialization.setId(specializationDTO.getId());
        specialization.setName(specializationDTO.getName());

        return specialization;
    }

    public static DoctorSpecialization mapDoctorSpecializationDTOtoDoctorSpecialization(DoctorSpecializationDTO doctorSpecializationDTO){
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization();
        doctorSpecialization.setSpecialization(DTOsMapper.mapSpecializationDTOtoSpecialization(doctorSpecializationDTO.getSpecialization()));
        doctorSpecialization.setDoctor(DTOsMapper.mapDoctorDTOtoDoctor(doctorSpecializationDTO.getDoctor()));
        doctorSpecialization.setSchedules(doctorSpecializationDTO.getSchedules());

        return doctorSpecialization;
    }

    public static Schedule mapScheduleDTOtoSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        schedule.setDayOfWeek(scheduleDTO.getDayOfWeek());
        schedule.setDateFrom(scheduleDTO.getDateFrom());
        schedule.setDateTo(scheduleDTO.getDateTo());

        return schedule;
    }
}
