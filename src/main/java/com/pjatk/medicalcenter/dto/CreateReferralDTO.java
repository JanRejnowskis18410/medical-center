package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateReferralDTO {

    @NotNull(message = "Appointment id is required")
    private Long issueAppointmentId;

    @NotNull(message = "Patient id is required")
    private Long patientId;

    @NotNull(message = "Medical service is required")
    private Long medicalServiceId;

    @NotNull(message = "Expiry date is required")
    @Future(message = "Incorrect date")
    private LocalDate expiryDate;
}
