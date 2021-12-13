package com.pjatk.medicalcenter.dto;

import java.time.LocalDate;
import java.util.List;

public class AppointmentCreatePrescriptionDTO {

    private LocalDate expiryDate;
    private Integer accessCode;
    private List<CreatePrescriptionMedicationDTO> medications;
}
