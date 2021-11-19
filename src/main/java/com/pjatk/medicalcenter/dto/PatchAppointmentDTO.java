package com.pjatk.medicalcenter.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
public class PatchAppointmentDTO {

    @NotNull
    private JsonNullable<Long> patientId = JsonNullable.undefined();

    private JsonNullable<Long> referralId = JsonNullable.undefined();
}
