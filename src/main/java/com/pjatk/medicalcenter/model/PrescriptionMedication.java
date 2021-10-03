package com.pjatk.medicalcenter.model;

import javax.persistence.*;

@Entity
public class PrescriptionMedication {

    @EmbeddedId
    private PrescriptionMedicationId id = new PrescriptionMedicationId();

    @ManyToOne
    @MapsId("prescriptionId")
    private Prescription prescription;

    @ManyToOne
    @MapsId("medicationId")
    private Medication medication;

    @Column(nullable = false)
    private int numberOfPackages;

    @Column(nullable = false)
    private String dosing;
}
