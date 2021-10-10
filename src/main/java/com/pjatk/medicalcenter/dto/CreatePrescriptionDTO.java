package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreatePrescriptionDTO {

    private Long id;

    private int accessCode;

    private byte[] binaryCode;

    private LocalDate dateFrom;

    private List<CreatePrescriptionMedicationDTO> medications;
}
