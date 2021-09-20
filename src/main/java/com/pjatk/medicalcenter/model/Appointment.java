package com.pjatk.medicalcenter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "appointment_type")
public abstract class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "appointment_language",
            joinColumns = {@JoinColumn(name = "appointment_id")},
            inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private Set<Language> languages = new HashSet<>();

    @OneToMany(mappedBy = "appointment")
    private Set<AppointmentCheckUp> appointmentCheckUps = new HashSet<>();

    @Column(
            nullable = false
    )
    @NonNull
    private LocalDateTime date;

    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean confirmed;

    @Column
    private String recommendations;

    @Column
    private String description;
}
