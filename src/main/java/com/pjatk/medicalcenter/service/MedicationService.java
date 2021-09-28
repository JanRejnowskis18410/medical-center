package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getMedications() { return medicationRepository.findAll(); }
}
