package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.CheckUp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckUpDTO {

    private Long id;

    private String name;

    public CheckUpDTO(CheckUp checkUp) {
        this.id = checkUp.getId();
        this.name = checkUp.getName();
    }
}
