package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getPrescriptions(){
        return prescriptionRepository.findAll();
    }
}
