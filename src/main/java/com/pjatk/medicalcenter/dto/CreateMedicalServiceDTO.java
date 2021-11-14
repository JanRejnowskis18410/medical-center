package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.MedicalService;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateMedicalServiceDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private boolean facilityService;
    @NotNull
    private boolean doneByMedicalStaff;
    @NotNull
    private long specializationId;
}
