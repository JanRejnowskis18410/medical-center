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
        PL, EN, DE, RU
    }

    @Column(name = "PWZ")
    private String PWZ;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();

    @ElementCollection(targetClass = Language.class)
    @CollectionTable(name = "language", joinColumns = @JoinColumn(name = "doctor_id"))
    @Enumerated(EnumType.STRING)
    @Column (
            nullable = false,
            name = "doctor_language"
    )
    public Set<Language> languages = new HashSet<>();

    public void addDoctorSpecialization(DoctorSpecialization doctorSpecialization){
        this.doctorSpecializations.add(doctorSpecialization);
    }
}
