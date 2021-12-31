package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DoctorWithSpecializationDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String pesel;
    private String pwz;
    private List<Doctor.Language> languages;

   private List<SpecializationWithSchedulesDTO> specializationWithSchedules = new ArrayList<>();

   public DoctorWithSpecializationDTO(Doctor doctor){
       this.id=doctor.getId();
       this.firstName=doctor.getFirstName();
       this.lastName=doctor.getLastName();
       this.email=doctor.getUser().getEmail();
       this.birthDate= doctor.getBirthDate();
       this.pesel=doctor.getPesel();
       this.pwz =doctor.getPWZ();
       this.specializationWithSchedules =doctor.getDoctorSpecializations().stream().map(SpecializationWithSchedulesDTO::new).collect(Collectors.toList());
       this.languages = new ArrayList<>(doctor.getLanguages());
   }

}
