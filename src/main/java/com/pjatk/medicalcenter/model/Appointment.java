package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

    public enum AppointmentType {
        TELEPHONE, FACILITY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne(optional = false)
    private Service service;

    @Column(
            nullable = false
    )
    private LocalDateTime date;

    @Column(
            nullable = false
    )
    @Type(type = "numeric_boolean")
    private boolean confirmed;

    @Column
    private String recommendations;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private AppointmentType type;
}
