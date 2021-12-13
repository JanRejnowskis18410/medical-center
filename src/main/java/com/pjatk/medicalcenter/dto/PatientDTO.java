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

    private Long id;

    private Address address;

    @NotEmpty(message = "Phone number required")
    private String phoneNumber;

    @NotEmpty(message = "First name required")
    private String firstName;

    @NotEmpty(message = "Last name required")
    private String lastName;

    @NotEmpty(message = "Email required")
    @Email(message = "Email is not valid",
            regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull(message = "Birth date required")
    @Past
    private LocalDate birthDate;

    @NotEmpty(message = "PESEL required")
    private String pesel;

    private List<PatientsFileDTO> patientsFiles;

    public PatientDTO(Patient patient){
        this.id=patient.getId();
        this.address=patient.getAddress();
        this.phoneNumber=patient.getPhoneNumber();
        this.firstName=patient.getFirstName();
        this.lastName=patient.getLastName();
        this.email=patient.getEmail();
        this.birthDate= patient.getBirthDate();
        this.pesel=patient.getPesel();
        if(Objects.nonNull(patient.getPatientsFiles()))
            this.patientsFiles=patient.getPatientsFiles().stream().map(PatientsFileDTO::new).collect(Collectors.toList());
    }
}
