package com.pjatk.medicalcenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false
    )
    private int accessCode;

    @Column(
            nullable = false
    )
    private LocalDate dateFrom;

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    private byte[] binaryCode;
}
