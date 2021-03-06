package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Schedule;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDTO {

    private long id;
    @NonNull
    private LocalDateTime dateFrom;
    @NonNull
    private LocalDateTime dateTo;

    public ScheduleDTO(Schedule schedule){
        this.id = schedule.getId();
        this.dateFrom = schedule.getDateFrom();
        this.dateTo = schedule.getDateTo();
    }
}
