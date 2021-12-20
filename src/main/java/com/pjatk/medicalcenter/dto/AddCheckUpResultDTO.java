package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddCheckUpResultDTO {

    @NotNull
    private JsonNullable<@NotEmpty String> result = JsonNullable.undefined();

    private JsonNullable<String> doctorsDescription = JsonNullable.undefined();

    @NotNull
    private JsonNullable<@NotNull Byte[]> file;
}
