package com.pjatk.medicalcenter.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "appointment_type")
public abstract class Appointment {

    public enum Language {
        PL, EN, DE, RU
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Service service;

    @Column(
            nullable = false
    )
    private LocalDate date;

    @Column(
            nullable = false
    )
    @Type(type = "numeric_boolean")
    private boolean confirmed;

    @Column
    private String recommendations;

    @Column
    private String description;

    @ElementCollection
    @CollectionTable(name = "appointment_languages", joinColumns = @JoinColumn(name = "appointment_id"))
    @Column(name = "language")
    private Set<Language> languages = EnumSet.noneOf(Language.class);
}
