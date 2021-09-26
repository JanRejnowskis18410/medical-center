package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    public enum DayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private DayOfWeek dayOfWeek;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
