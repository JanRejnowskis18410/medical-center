package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Specialization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SpecializationWithDoctorsDTO {

    private Long id;
    private String name;
    private List<DoctorDTO> doctor = new ArrayList<>();

    public SpecializationWithDoctorsDTO(Specialization specialization){
        this.id=specialization.getId();
        this.name=specialization.getName();
        this.doctor =specialization.getDoctorSpecializations().stream().map(docSpec -> new DoctorDTO(docSpec.getDoctor())).collect(Collectors.toList());
    }
}

