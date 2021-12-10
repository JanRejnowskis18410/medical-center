package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Medication;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicationDTO {

    private Long id;

    private String name;

    private Medication.Unit unit;

    private double payment;

    private int quantity;


    public MedicationDTO(Medication medication) {
        this.id = medication.getId();
        this.name = medication.getName();
        this.unit = medication.getUnit();
        this.payment = medication.getPayment();
        this.quantity = medication.getQuantity();
    }
}
