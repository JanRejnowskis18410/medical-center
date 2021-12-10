package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.CheckUp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CheckUpDTO {

    private Long id;
    @NotEmpty(message = "Name required")
    private String name;

    public CheckUpDTO(CheckUp checkUp) {
        this.id = checkUp.getId();
        this.name = checkUp.getName();
    }
}
