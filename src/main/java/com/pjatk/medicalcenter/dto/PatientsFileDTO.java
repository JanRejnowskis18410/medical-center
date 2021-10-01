package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.PatientsFile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientsFileDTO {

    private Long id;

    private String name;

    private byte[] file;

    public PatientsFileDTO(PatientsFile patientsFile) {
        this.id=patientsFile.getId();
        this.name=patientsFile.getName();
        this.file=patientsFile.getFile();
    }
}
