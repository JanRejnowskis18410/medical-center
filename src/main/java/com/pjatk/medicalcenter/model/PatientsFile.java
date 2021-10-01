package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class PatientsFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "file", columnDefinition = "BLOB")
    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
