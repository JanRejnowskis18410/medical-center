package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends Person{

    public enum Language {
        PL, EN
    }

    @Column(name = "PWZ", nullable = false, length = 7, unique = true)
    private String pwz;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    @ElementCollection(targetClass = Language.class)
    @CollectionTable(name = "language", joinColumns = @JoinColumn(name = "doctor_id"))
    @Enumerated(EnumType.STRING)
    @Column (
            nullable = false,
            name = "doctor_language",
            length = 50
    )
    public Set<Language> languages = new HashSet<>();

    public void addDoctorSpecialization(DoctorSpecialization doctorSpecialization){
        this.doctorSpecializations.add(doctorSpecialization);
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }
}
