package com.pjatk.medicalcenter.model;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientsFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "file", columnDefinition = "LONGBLOB", nullable = false )
    private Byte[] file;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "upload_date", nullable = false)
    private LocalDate uploadDate = LocalDate.now();

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

}
