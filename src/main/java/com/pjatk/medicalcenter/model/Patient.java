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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    private List<PatientsFile> patientsFiles = new ArrayList<>();

    //TODO is it needed?
//    public void setPatientsFiles(List<PatientsFile> patientsFiles) {
//        getPatientsFiles().forEach(e -> e.setPatient(this));
//        this.patientsFiles = patientsFiles;
//    }
}
