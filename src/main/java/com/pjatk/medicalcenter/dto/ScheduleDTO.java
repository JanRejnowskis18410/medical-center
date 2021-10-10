package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Schedule;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDTO {

    @NonNull
    private Schedule.DayOfWeek dayOfWeek;
    @NonNull
    private LocalDateTime dateFrom;
    @NonNull
    private LocalDateTime dateTo;

    public ScheduleDTO(Schedule schedule){
        this.dayOfWeek = schedule.getDayOfWeek();
        this.dateFrom = schedule.getDateFrom();
        this.dateTo = schedule.getDateTo();
    }
}
