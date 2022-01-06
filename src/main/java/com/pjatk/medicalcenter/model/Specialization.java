package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();

    @OneToMany(mappedBy = "specialization")
    private List<MedicalService> medicalServices = new ArrayList<>();

    public void addDoctorSpecialization(DoctorSpecialization doctorSpecialization){
        this.doctorSpecializations.add(doctorSpecialization);
    }
    public void addMedicalService(MedicalService medicalService){
        this.medicalServices.add(medicalService);
    }
}
