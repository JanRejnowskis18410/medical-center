package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.repository.PrescriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, PrescriptionMedicationService prescriptionMedicationService) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(long id) {
        return prescriptionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prescription does not exist"));
    }

    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }
}
