package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorsByMedicalServiceIdAndLanguagesDTO {
    private long medicalServiceId;
    private Doctor.Language language;
}
