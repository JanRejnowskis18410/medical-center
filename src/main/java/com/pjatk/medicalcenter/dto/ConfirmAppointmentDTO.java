package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotNull;

@Getter
public class ConfirmAppointmentDTO {

    @NotNull
    private JsonNullable<Long> patientId = JsonNullable.undefined();

    private JsonNullable<Long> referralId = JsonNullable.undefined();
}
