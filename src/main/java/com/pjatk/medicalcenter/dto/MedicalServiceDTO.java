package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.MedicalService;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MedicalServiceDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private boolean facilityService;
    @NotNull
    private boolean doneByMedicalStaff;
    private long specializationId;


    public MedicalServiceDTO(MedicalService medicalService) {
        this.id = medicalService.getId();
        this.name = medicalService.getName();
        this.facilityService = medicalService.isFacilityService();
        this.doneByMedicalStaff = medicalService.isDoneByMedicalStaff();
        this.specializationId = medicalService.getSpecialization().getId();
    }

}
