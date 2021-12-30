package com.pjatk.medicalcenter.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreatePrescriptionDTO {

    @NotNull
    @Future(message = "Future date required")
    private LocalDate expiryDate;

    @NotNull(message = "Acccess code is required")
    private Integer accessCode;

    @NotNull(message = "Patient is required")
    private Long patientId;

    @NotNull(message = "Appointment is required")
    private Long appointmentId;

    @NotEmpty(message = "At least 1 medication is required")
    private List<CreatePrescriptionMedicationDTO> medications;
}
