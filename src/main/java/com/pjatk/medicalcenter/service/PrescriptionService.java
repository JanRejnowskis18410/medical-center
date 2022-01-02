package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.repository.PrescriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.pjatk.medicalcenter.util.ErrorMessages.PRESCRIPTION_NOT_FOUND_ERROR_MESS;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(long id) {
        return prescriptionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PRESCRIPTION_NOT_FOUND_ERROR_MESS));
    }

    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }
}
