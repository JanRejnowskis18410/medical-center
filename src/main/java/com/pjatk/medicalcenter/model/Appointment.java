package com.pjatk.medicalcenter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public abstract class Appointment {

    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long id;

    @Column(
            nullable = false
    )
    @NonNull
    private LocalDateTime date;

    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean confirmed;

    private String recommendations;

    private String description;
}
