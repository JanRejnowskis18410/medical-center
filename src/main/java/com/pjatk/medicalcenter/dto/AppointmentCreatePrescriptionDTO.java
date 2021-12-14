package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentCreatePrescriptionDTO {

    private LocalDate expiryDate;
    private Integer accessCode;
    private List<CreatePrescriptionMedicationDTO> medications;
}
