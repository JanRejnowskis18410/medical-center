package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.MedicalService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class MedicalServiceDTO {

    private Long id;
    private String name;
    private Boolean facilityService;
    private Boolean doneByMedicalStaff;
    private Long specializationId;

    public MedicalServiceDTO(MedicalService medicalService) {
        this.id = medicalService.getId();
        this.name = medicalService.getName();
        this.facilityService = medicalService.isFacilityService();
        this.doneByMedicalStaff = medicalService.isDoneByMedicalStaff();
        if(!Objects.isNull(medicalService.getSpecialization()))
            this.specializationId = medicalService.getSpecialization().getId();
    }

}
