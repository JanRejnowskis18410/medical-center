package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.model.PrescriptionMedication;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrescriptionMedicationDTO {

    private Long id;

    private String name;

    private Medication.Unit unit;

    private double payment;

    private int quantity;

    private boolean extendable;

    private int numberOfPackages;

    private String dosing;

    public PrescriptionMedicationDTO(PrescriptionMedication prescriptionMedication) {
        Medication medication = prescriptionMedication.getMedication();
        this.id = medication.getId();
        this.name = medication.getName();
        this.unit = medication.getUnit();
        this.quantity = medication.getQuantity();
        this.numberOfPackages = prescriptionMedication.getNumberOfPackages();
        this.dosing = prescriptionMedication.getDosing();
    }
}
