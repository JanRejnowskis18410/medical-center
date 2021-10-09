package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePrescriptionMedicationDTO {

    private Long id;

    private int numberOfPackages;

    private String dosing;
}
