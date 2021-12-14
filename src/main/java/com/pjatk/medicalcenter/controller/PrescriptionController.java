package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.CreatePrescriptionDTO;
import com.pjatk.medicalcenter.dto.CreatePrescriptionMedicationDTO;
import com.pjatk.medicalcenter.dto.PrescriptionDTO;
import com.pjatk.medicalcenter.model.Medication;
import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.model.PrescriptionMedication;
import com.pjatk.medicalcenter.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final PrescriptionMedicationService prescriptionMedicationService;
    private final MedicationService medicationService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    public PrescriptionController(PrescriptionService prescriptionService, PrescriptionMedicationService prescriptionMedicationService, MedicationService medicationService, DoctorService doctorService, PatientService patientService, AppointmentService appointmentService) {
        this.prescriptionService = prescriptionService;
        this.prescriptionMedicationService = prescriptionMedicationService;
        this.medicationService = medicationService;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
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
    public ResponseEntity<Prescription> addPrescription(@Valid @RequestBody CreatePrescriptionDTO createPrescriptionDTO) {
        Prescription createdPrescription = prescriptionService.addPrescription(createPrescription(createPrescriptionDTO));
        prescriptionMedicationService.addPrescriptionMedications(createdPrescription.getPrescriptionMedications());
        return ResponseEntity.created(URI.create(String.format("/prescriptions/%d", createdPrescription.getId()))).build();
    }

    private List<PrescriptionMedication> addMedicationsToPrescription(@Valid List<CreatePrescriptionMedicationDTO> createPrescriptionMedicationDTOs, Prescription prescription) {
        List<PrescriptionMedication> prescriptionsMedications = new ArrayList<>();
        createPrescriptionMedicationDTOs.forEach(createPrescriptionMedicationDTO -> {
            Medication medication = medicationService.getMedicationById(createPrescriptionMedicationDTO.getMedicationId());
            PrescriptionMedication prescriptionMedication = createPrescriptionMedication (
                                                                    createPrescriptionMedicationDTO.getNumberOfPackages(),
                                                                    createPrescriptionMedicationDTO.getDosing(),
                                                                    prescription,
                                                                    medication
                                                            );
            prescriptionsMedications.add(prescriptionMedication);
        });
        return prescriptionsMedications;
    }

    private PrescriptionMedication createPrescriptionMedication(int numberOfPackages, String dosing, Prescription prescription, Medication medication) {
        PrescriptionMedication prescriptionMedication = new PrescriptionMedication();
        prescriptionMedication.setNumberOfPackages(numberOfPackages);
        prescriptionMedication.setDosing(dosing);
        prescriptionMedication.setPrescription(prescription);
        prescriptionMedication.setMedication(medication);
        return prescriptionMedication;
    }

    public Prescription createPrescription(CreatePrescriptionDTO createPrescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setAccessCode(createPrescriptionDTO.getAccessCode());
        prescription.setExpiryDate(createPrescriptionDTO.getExpiryDate());
        prescription.setDoctor(doctorService.getDoctorById(createPrescriptionDTO.getDoctorId()));
        prescription.setPatient(patientService.getPatientById(createPrescriptionDTO.getPatientId()));
        prescription.setAppointment(appointmentService.getAppointmentById(createPrescriptionDTO.getAppointmentId()));
        prescription.setPrescriptionMedications(addMedicationsToPrescription(createPrescriptionDTO.getMedications(), prescription));
        return prescription;
    }
}
