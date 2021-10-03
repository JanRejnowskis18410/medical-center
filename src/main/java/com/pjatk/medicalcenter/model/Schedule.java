package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    public enum DayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private DayOfWeek dayOfWeek;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
