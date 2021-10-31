package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorsByMedicalServiceIdAndLanguagesDTO {
    private long serviceId;
    private Doctor.Language language;
}
