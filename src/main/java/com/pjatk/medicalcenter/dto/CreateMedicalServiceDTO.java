package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.MedicalService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateMedicalServiceDTO {

    private Long id;
    private String name;
    private boolean facilityService;
    private long specializationId;
}
