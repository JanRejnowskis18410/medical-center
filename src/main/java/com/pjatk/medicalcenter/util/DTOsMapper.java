package com.pjatk.medicalcenter.util;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.DoctorSpecialization;
import com.pjatk.medicalcenter.model.Schedule;
import com.pjatk.medicalcenter.model.Specialization;

import java.util.ArrayList;
import java.util.List;
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
        doctor.getLanguages().addAll(doctorWithSpecializationDTO.getLanguages());

        List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();
        for (SpecializationWithSchedulesDTO specializationWithSchedulesDTO : doctorWithSpecializationDTO.getSpecializationWithSchedulesDTOs()) {
            Specialization specialization = new Specialization();
            specialization.setId(specializationWithSchedulesDTO.getId());
            specialization.setName(specializationWithSchedulesDTO.getName());

            DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
            doctorSpecialization.setSchedules(specializationWithSchedulesDTO.getSchedules().stream().map(DTOsMapper::mapScheduleDTOtoSchedule).collect(Collectors.toList()));
            doctorSpecializations.add(doctorSpecialization);
        }
        doctor.setDoctorSpecializations(doctorSpecializations);

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
        doctor.getLanguages().addAll(doctorDTO.getLanguages());

        return doctor;
    }

//    public static Specialization mapSpecializationWithDoctorsDTOtoSpecialization(SpecializationWithDoctorsDTO specializationWithDoctorsDTO) {
//        Specialization specialization = new Specialization();
//        specialization.setId(specializationWithDoctorsDTO.getId());
//        specialization.setName(specializationWithDoctorsDTO.getName());
//
//        List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();
//        for (DoctorDTO doctorDTO : specializationWithDoctorsDTO.getDoctorDTOs()) {
//            Doctor doctor = DTOsMapper.mapDoctorDTOtoDoctor(doctorDTO);
//            DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
//            doctorSpecializations.add(doctorSpecialization);
//        }
//        specialization.setDoctorSpecializations(doctorSpecializations);
//
//        return specialization;
//    }

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

//    public static Specialization SpecializationWithSchedulesDTOtoSpecialization(SpecializationWithSchedulesDTO specializationWithSchedulesDTO){
//        Specialization specialization = new Specialization();
//        specialization.setId(specializationWithSchedulesDTO.getId());
//        specialization.setName(specializationWithSchedulesDTO.getName());
//        specialization.
//    }

    public static Schedule mapScheduleDTOtoSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDTO.getId());
        schedule.setDayOfWeek(scheduleDTO.getDayOfWeek());
        schedule.setDateFrom(scheduleDTO.getDateFrom());
        schedule.setDateTo(scheduleDTO.getDateTo());

        return schedule;
    }
}