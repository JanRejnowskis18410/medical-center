package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Person{

    @Embedded
    private Address address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "patient")
    @Setter(AccessLevel.NONE)
    private List<PatientsFile> patientsFiles = new ArrayList<>();

    public void setPatientsFiles(List<PatientsFile> patientsFiles) {
        patientsFiles.forEach(e -> e.setPatient(this));
        this.patientsFiles = patientsFiles;
    }
}
