package com.pjatk.medicalcenter.security.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
@NoArgsConstructor
public class ChangeCredentialsDTO {
    JsonNullable<String> password = JsonNullable.undefined();
    JsonNullable<String> email = JsonNullable.undefined();
}
