package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Prescription;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PrescriptionDTO {

    private Long id;
    private int accessCode;
    private LocalDate expiryDate;
    private LocalDate creationDate;
    private List<PrescriptionMedicationDTO> medications;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorPwz;

    public PrescriptionDTO(Prescription prescription) {
        this.id = prescription.getId();
        this.accessCode = prescription.getAccessCode();
        this.expiryDate = prescription.getExpiryDate();
        this.creationDate = prescription.getCreationDate();
        this.medications = prescription.getPrescriptionMedications().stream().map(PrescriptionMedicationDTO::new).collect(Collectors.toList());
        this.doctorFirstName = prescription.getAppointment().getDoctor().getFirstName();
        this.doctorLastName = prescription.getAppointment().getDoctor().getLastName();
        this.doctorPwz = prescription.getAppointment().getDoctor().getPwz();
    }
}
