package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorWeeklyScheduleDTO {

    private List<Schedule> weeklySchedule = new ArrayList<>();

    public DoctorWeeklyScheduleDTO(List<ScheduleDTO> schedules){
        schedules.forEach(sch -> weeklySchedule.add(new Schedule(sch.getDateFrom(), sch.getDateTo())));
    }

    @Getter
    public static class Schedule {
        LocalDateTime startDate;
        LocalDateTime endDate;

        Schedule(LocalDateTime startDate, LocalDateTime endDate){
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}
