package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.PrescriptionMedication;
import com.pjatk.medicalcenter.repository.PrescriptionMedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionMedicationService {

    private final PrescriptionMedicationRepository prescriptionMedicationRepository;

    public PrescriptionMedicationService(PrescriptionMedicationRepository prescriptionMedicationRepository) {
        this.prescriptionMedicationRepository = prescriptionMedicationRepository;
    }

    public List<PrescriptionMedication> addPrescriptionMedications(List<PrescriptionMedication> prescriptionMedications) {
        return prescriptionMedicationRepository.saveAll(prescriptionMedications);
    }
}
