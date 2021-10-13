package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.DoctorSpecialization;
import com.pjatk.medicalcenter.model.Schedule;
import com.pjatk.medicalcenter.model.Specialization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SpecializationWithSchedulesDTO {

    private Long id;
    private String name;
    private List<ScheduleDTO> schedules = new ArrayList<>();

    public SpecializationWithSchedulesDTO(DoctorSpecialization doctorSpecialization){
        this.id = doctorSpecialization.getSpecialization().getId();
        this.name = doctorSpecialization.getSpecialization().getName();
        this.schedules = doctorSpecialization.getSchedules().stream().map(ScheduleDTO::new).collect(Collectors.toList());
    }

}
