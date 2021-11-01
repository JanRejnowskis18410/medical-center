package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(optional = false)
    @Setter(AccessLevel.NONE)
    private Patient patient;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionMedication> prescriptionMedications = new ArrayList<>();

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    private byte[] binaryCode;

    public void addPrescriptionMedication(PrescriptionMedication prescriptionMedication) {
        prescriptionMedications.add(prescriptionMedication);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.addPrescription(this);
    }
}
