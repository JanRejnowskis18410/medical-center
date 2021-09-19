package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.PatientsFile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientsFileDTO {

    private String name;

    private byte[] file;

    public PatientsFileDTO(PatientsFile patientsFile) {
        this.name=patientsFile.getName();
        this.file=patientsFile.getFile();
    }
}
