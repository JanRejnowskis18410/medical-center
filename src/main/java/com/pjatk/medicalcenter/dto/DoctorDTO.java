package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String pesel;
    private String PWZ;

    public DoctorDTO(Doctor doctor){
        this.id=doctor.getId();
        this.firstName=doctor.getFirstName();
        this.lastName=doctor.getLastName();
        this.email=doctor.getEmail();
        this.birthDate= doctor.getBirthDate();
        this.pesel=doctor.getPesel();
        this.PWZ=doctor.getPWZ();
    }
}
