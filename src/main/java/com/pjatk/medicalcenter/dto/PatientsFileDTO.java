package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.PatientsFile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PatientsFileDTO {

    private Long id;
    @NotEmpty(message = "Field name is required")
    private String name;
    @NotEmpty(message = "Description is required")
    @Size(max = 100, message = "At least 100 characters are required")
    private String description;
    @NotEmpty(message = "File attachment is required")
    private Byte[] file;
    @NotEmpty(message = "File type is required")
    private String type;

    public PatientsFileDTO(PatientsFile patientsFile) {
        this.id=patientsFile.getId();
        this.name=patientsFile.getName();
        this.description=patientsFile.getDescription();
        this.file=patientsFile.getFile();
        this.type=patientsFile.getType();
    }
}
