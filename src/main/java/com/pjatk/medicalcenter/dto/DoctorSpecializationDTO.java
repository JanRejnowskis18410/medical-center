package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.DoctorSpecialization;
import com.pjatk.medicalcenter.model.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorSpecializationDTO {

    private DoctorDTO doctor;
    private SpecializationDTO specialization;
    private List<Schedule> schedules = new ArrayList<>();

    public DoctorSpecializationDTO(DoctorSpecialization doctorSpecialization){
        this.doctor = new DoctorDTO(doctorSpecialization.getDoctor());
        this.specialization = new SpecializationDTO(doctorSpecialization.getSpecialization());
        this.schedules=doctorSpecialization.getSchedules();
    }

}
