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

    private byte[] binaryCode;

    private LocalDate dateFrom;

    private List<PrescriptionMedicationDTO> medications;

    public PrescriptionDTO(Prescription prescription) {
        this.id = prescription.getId();
        this.accessCode = prescription.getAccessCode();
        this.binaryCode = prescription.getBinaryCode();
        this.dateFrom = prescription.getDateFrom();
        this.medications = prescription.getPrescriptionMedications().stream().map(PrescriptionMedicationDTO::new).collect(Collectors.toList());
    }
}
