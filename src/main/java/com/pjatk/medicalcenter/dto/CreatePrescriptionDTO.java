package com.pjatk.medicalcenter.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
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

    @NotNull
    @Min(1)
    private Integer accessCode;

    @NotNull(message = "Doctor is required")
    private Long doctorId;

    @NotNull
    private Long patientId;

    @NotNull
    private Long appointmentId;

    @NotEmpty(message = "At least 1 medication is required")
    private List<CreatePrescriptionMedicationDTO> medications;
}
