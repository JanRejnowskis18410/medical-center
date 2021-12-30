package com.pjatk.medicalcenter.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrescriptionMedication {

    @EmbeddedId
    private PrescriptionMedicationId id = new PrescriptionMedicationId();

    @ManyToOne
    @MapsId("prescriptionId")
    @Setter(AccessLevel.NONE)
    private Prescription prescription;

    @ManyToOne
    @MapsId("medicationId")
    @Setter(AccessLevel.NONE)
    private Medication medication;

    @Column(nullable = false)
    private int numberOfPackages;

    @Column(nullable = false, length = 100)
    private String dosing;

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
        prescription.addPrescriptionMedication(this);
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
        medication.addPrescriptionMedication(this);
    }
}
