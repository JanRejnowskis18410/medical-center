package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Address;
import com.pjatk.medicalcenter.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
public class PatientDTO {

    private Long id;

    private Address address;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

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
        if(Objects.nonNull(patientsFiles))
            this.patientsFiles=patient.getPatientsFiles().stream().map(PatientsFileDTO::new).collect(Collectors.toList());
    }
}
