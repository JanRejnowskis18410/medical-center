package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.DoctorSpecialization;
import com.pjatk.medicalcenter.model.Specialization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpecializationDTO {

    private Long id;
    private String name;

    public SpecializationDTO(Specialization specialization){
        this.id=specialization.getId();
        this.name=specialization.getName();
    }
}
