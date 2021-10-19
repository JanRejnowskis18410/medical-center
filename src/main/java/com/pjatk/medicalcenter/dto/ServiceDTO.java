package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.MedicalService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDTO {

    private Long id;

    private String name;

    public ServiceDTO(MedicalService medicalService) {
        this.id = medicalService.getId();
        this.name = medicalService.getName();
    }

}
