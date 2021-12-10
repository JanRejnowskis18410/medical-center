package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CreatePrescriptionMedicationDTO {

    @NotNull
    @Min(value = 1, message = "Min number of packages is 1")
    private Integer numberOfPackages;

    private String dosing;

    @NotNull
    private Long medicationId;
}
