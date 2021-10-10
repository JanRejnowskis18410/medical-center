package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.PrescriptionMedication;
import com.pjatk.medicalcenter.repository.PrescriptionMedicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionMedicationService {

    private final PrescriptionMedicationRepository prescriptionMedicationRepository;

    public PrescriptionMedicationService(PrescriptionMedicationRepository prescriptionMedicationRepository) {
        this.prescriptionMedicationRepository = prescriptionMedicationRepository;
    }

    public PrescriptionMedication addPrescriptionMedication(PrescriptionMedication prescriptionMedication) {
        return prescriptionMedicationRepository.save(prescriptionMedication);
    }
}
