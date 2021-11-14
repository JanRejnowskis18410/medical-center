package com.pjatk.medicalcenter.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Prescription prescription;

    @ManyToOne
    @MapsId("medicationId")
    @Setter(AccessLevel.NONE)
    @NotNull
    private Medication medication;

    @Column(nullable = false)
    @Min(1)
    private int numberOfPackages;

    @Column(nullable = false)
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
