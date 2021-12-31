package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {

    private Long id;
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

    @NotEmpty(message = "PWZ is required")
    private String pwz;

    @NotEmpty(message = "At least 1 language is required")
    private List<Doctor.Language> languages;

    public DoctorDTO(Doctor doctor){
        this.id=doctor.getId();
        this.firstName=doctor.getFirstName();
        this.lastName=doctor.getLastName();
        this.email=doctor.getUser().getEmail();
        this.birthDate= doctor.getBirthDate();
        this.pesel=doctor.getPesel();
        this.pwz =doctor.getPWZ();
        this.languages = new ArrayList<>(doctor.getLanguages());
    }
}
