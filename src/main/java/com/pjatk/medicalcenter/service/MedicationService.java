package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.repository.MedicationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getMedications() {
        return medicationRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Optional<Medication> findMedicationById(long id) {
        return medicationRepository.findById(id);
    }

    public Medication getMedicationById(long id) {
        return findMedicationById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication does not exist"));
    }

    public Medication addMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Medication updateMedication(Medication medication) {
        if (medicationRepository.findById(medication.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication does not exists")) != null) {
            return medicationRepository.save(medication);
        }

        return null;
    }

    public void deletePatientById(long id) {
        medicationRepository.delete(medicationRepository.getById(id));
    }
}
