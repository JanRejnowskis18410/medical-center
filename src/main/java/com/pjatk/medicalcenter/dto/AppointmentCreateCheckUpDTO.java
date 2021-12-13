package com.pjatk.medicalcenter.dto;

import org.openapitools.jackson.nullable.JsonNullable;

public class AppointmentCreateCheckUpDTO {
    private Long checkUpId;
    private JsonNullable<String> result = JsonNullable.undefined();
    private JsonNullable<String> description = JsonNullable.undefined();
    private JsonNullable<byte[]> file = JsonNullable.undefined();
}
