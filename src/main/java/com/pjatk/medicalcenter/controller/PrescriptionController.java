package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.CreatePrescriptionDTO;
import com.pjatk.medicalcenter.dto.PrescriptionDTO;
import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.model.PrescriptionMedication;
import com.pjatk.medicalcenter.service.MedicationService;
import com.pjatk.medicalcenter.service.PrescriptionMedicationService;
import com.pjatk.medicalcenter.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final PrescriptionMedicationService prescriptionMedicationService;
    private final MedicationService medicationService;

    public PrescriptionController(PrescriptionService prescriptionService, PrescriptionMedicationService prescriptionMedicationService, MedicationService medicationService) {
        this.prescriptionService = prescriptionService;
        this.prescriptionMedicationService = prescriptionMedicationService;
        this.medicationService = medicationService;
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getPrescriptions();
        return ResponseEntity.ok(prescriptions.stream().map(PrescriptionDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescriptionById(@PathVariable long id) {
        return ResponseEntity.ok(new PrescriptionDTO(prescriptionService.getPrescriptionById(id)));
    }

    @PostMapping
    public ResponseEntity<Prescription> addPrescription(@RequestBody CreatePrescriptionDTO createPrescriptionDTO) {
        Prescription createdPrescription = prescriptionService.addPrescription(mapCreatePrescriptionDTOToPrescription(createPrescriptionDTO));
        addMedicationsToPrescription(createPrescriptionDTO, createdPrescription);
        return ResponseEntity.created(URI.create(String.format("/prescriptions/%d", createdPrescription.getId()))).build();
    }

    private void addMedicationsToPrescription(CreatePrescriptionDTO createPrescriptionDTO, Prescription prescription) {
        createPrescriptionDTO.getMedications().forEach(createPrescriptionMedicationDTO -> {
            Optional<Medication> optionalMedication = medicationService.findMedicationById(createPrescriptionMedicationDTO.getId());
            optionalMedication.ifPresent(medication -> {
                int numberOfPackages = createPrescriptionMedicationDTO.getNumberOfPackages();
                String dosing = createPrescriptionMedicationDTO.getDosing();
                PrescriptionMedication prescriptionMedication = createPrescriptionMedication(numberOfPackages, dosing, prescription, medication);
                prescriptionMedicationService.addPrescriptionMedication(prescriptionMedication);
            });
        });
    }

    private PrescriptionMedication createPrescriptionMedication(int numberOfPackages, String dosing, Prescription prescription, Medication medication) {
        PrescriptionMedication prescriptionMedication = new PrescriptionMedication();
        prescriptionMedication.setNumberOfPackages(numberOfPackages);
        prescriptionMedication.setDosing(dosing);
        prescriptionMedication.setPrescription(prescription);
        prescriptionMedication.setMedication(medication);
        System.out.println(prescription.getPrescriptionMedications());
        System.out.println(medication.getPrescriptionMedications());
        return prescriptionMedication;
    }

    private Prescription mapCreatePrescriptionDTOToPrescription(CreatePrescriptionDTO createPrescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setId(createPrescriptionDTO.getId());
        prescription.setAccessCode(createPrescriptionDTO.getAccessCode());
        prescription.setExpiryDate(createPrescriptionDTO.getDateToUse());
        prescription.setBinaryCode(createPrescriptionDTO.getBinaryCode());

        return prescription;
    }
}
