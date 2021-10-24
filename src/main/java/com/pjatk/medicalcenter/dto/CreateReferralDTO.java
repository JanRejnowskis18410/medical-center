package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateReferralDTO {

    private Long id;

    private Long issueAppointmentId;

    private Long patientId;

    private Long medicalServiceId;

    private LocalDate expiryDate;
}
