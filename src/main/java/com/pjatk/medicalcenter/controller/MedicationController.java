package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.MedicationDTO;
import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medications")
@CrossOrigin
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

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getMedicationById(@PathVariable long id) {
        return ResponseEntity.ok(new MedicationDTO(medicationService.getMedicationById(id)));
    }

    @PostMapping
    public ResponseEntity<Medication> addMedication(@RequestBody MedicationDTO medicationDTO) {
        Medication createdMedication = medicationService.addMedication(mapMedicationDTOToMedication(medicationDTO));
        return ResponseEntity.created(URI.create(String.format("/medications/%d", createdMedication.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Medication> updateMedication(@RequestBody MedicationDTO medicationDTO) {
        Medication updatedMedication = medicationService.updateMedication(mapMedicationDTOToMedication(medicationDTO));
        return ResponseEntity.created(URI.create(String.format("/medications/%d", updatedMedication.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedication(@PathVariable long id) {
        medicationService.deletePatientById(id);
        return ResponseEntity.ok("Success");
    }

    private Medication mapMedicationDTOToMedication(MedicationDTO medicationDTO) {
        Medication medication = new Medication();
        medication.setId(medicationDTO.getId());
        medication.setName(medicationDTO.getName());
        medication.setUnit(medicationDTO.getUnit());
        medicationDTO.setQuantity(medicationDTO.getQuantity());

        return medication;
    }
}
