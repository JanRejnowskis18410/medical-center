package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Address;
import com.pjatk.medicalcenter.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
public class PatientDTO {

    @NotNull(message = "Id is required")
    private Long id;

    private Address address;

    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Birth date is required")
    @Past
    private LocalDate birthDate;

    @NotEmpty(message = "PESEL is required")
    private String pesel;

    private List<PatientsFileDTO> patientsFiles;

    public PatientDTO(Patient patient){
        this.id=patient.getId();
        this.address=patient.getAddress();
        this.phoneNumber=patient.getPhoneNumber();
        this.firstName=patient.getFirstName();
        this.lastName=patient.getLastName();
        this.birthDate= patient.getBirthDate();
        this.pesel=patient.getPesel();
        if(Objects.nonNull(patient.getPatientsFiles()))
            this.patientsFiles=patient.getPatientsFiles().stream().map(PatientsFileDTO::new).collect(Collectors.toList());
    }
}
