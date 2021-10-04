package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.PrescriptionDTO;
import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getPrescriptions();
        return ResponseEntity.ok(prescriptions.stream().map(PrescriptionDTO::new).collect(Collectors.toList()));
    }
}
