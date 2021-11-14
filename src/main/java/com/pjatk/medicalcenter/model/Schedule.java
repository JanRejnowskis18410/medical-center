package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    public enum DayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false),
            @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id", nullable = false)
    })
    private DoctorSpecialization doctorSpecialization;

    private DayOfWeek dayOfWeek;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
