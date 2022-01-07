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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false),
            @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id", nullable = false)
    })
    private DoctorSpecialization doctorSpecialization;

    @Column(name = "dateFrom", nullable = false)
    private LocalDateTime dateFrom;
    @Column(name = "dateTo", nullable = false)
    private LocalDateTime dateTo;
}
