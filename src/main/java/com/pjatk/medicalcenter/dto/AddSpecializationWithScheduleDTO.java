package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddSpecializationWithScheduleDTO {

    private long specializationId;
    private List<ScheduleDTO> schedules;

//    public AddSpecializationDTO(long specializationId, Schedule schedule) {
//        this.specializationId = specializationId;
//        this.schedule = schedule;
//    }
}
