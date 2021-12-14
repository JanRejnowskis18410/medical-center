package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentCreateReferralDTO {

    private Long medicalServiceId;
    private LocalDate expiryDate;
}
