package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentCreateAppointmentCheckUpDTO {
    private Long checkUpId;
    private JsonNullable<String> result = JsonNullable.undefined();
    private JsonNullable<String> description = JsonNullable.undefined();
    private JsonNullable<Byte[]> file = JsonNullable.undefined();
}
