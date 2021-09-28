package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.MedicationDTO;
import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> getMedications() {
        List<Medication> medications = medicationService.getMedications();
        return ResponseEntity.ok(medications.stream().map(MedicationDTO::new).collect(Collectors.toList()));
    }
}
