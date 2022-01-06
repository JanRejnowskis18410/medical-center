package com.pjatk.medicalcenter.security.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ChangeCredentialsDTO {
    @NotEmpty(message = "Password is required")
    String password;

    JsonNullable<String> email = JsonNullable.undefined();
}
