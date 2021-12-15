package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoneAppointmentDTO {

    @NotNull
    JsonNullable<String> description = JsonNullable.undefined();

    JsonNullable<String> recommendations = JsonNullable.undefined();

    JsonNullable<List<AppointmentCreateReferralDTO>> referrals = JsonNullable.undefined();

    JsonNullable<List<AppointmentCreatePrescriptionDTO>> prescriptions = JsonNullable.undefined();

    JsonNullable<List<AppointmentCreateAppointmentCheckUpDTO>> checkUps = JsonNullable.undefined();
}
