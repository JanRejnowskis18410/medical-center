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

    @Column(name = "dayOfWeek", nullable = false)
    private DayOfWeek dayOfWeek;
    @Column(name = "dateFrom", nullable = false)
    private LocalDateTime dateFrom;
    @Column(name = "dateTo", nullable = false)
    private LocalDateTime dateTo;
}
