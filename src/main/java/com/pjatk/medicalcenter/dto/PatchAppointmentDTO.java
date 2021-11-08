package com.pjatk.medicalcenter.dto;

import org.openapitools.jackson.nullable.JsonNullable;

public class PatchAppointmentDTO {

    private JsonNullable<Long> patientId = JsonNullable.undefined();

    private JsonNullable<Long> referralId = JsonNullable.undefined();

    public JsonNullable<Long> getPatientId() {
        return patientId;
    }

    public JsonNullable<Long> getReferralId() {
        return referralId;
    }
}
