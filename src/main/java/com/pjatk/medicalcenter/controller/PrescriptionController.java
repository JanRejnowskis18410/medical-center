//package com.pjatk.medicalcenter.controller;
//
//import com.pjatk.medicalcenter.dto.CreatePrescriptionDTO;
//import com.pjatk.medicalcenter.dto.CreatePrescriptionMedicationDTO;
//import com.pjatk.medicalcenter.dto.PrescriptionDTO;
//import com.pjatk.medicalcenter.model.Medication;
//import com.pjatk.medicalcenter.model.Prescription;
//import com.pjatk.medicalcenter.model.PrescriptionMedication;
//import com.pjatk.medicalcenter.service.*;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/prescriptions")
//@CrossOrigin
//public class PrescriptionController {
//
//    private final PrescriptionService prescriptionService;
//    private final PrescriptionMedicationService prescriptionMedicationService;
//    private final MedicationService medicationService;
//    private final DoctorService doctorService;
//    private final PatientService patientService;
//    private final AppointmentService appointmentService;
//
//    public PrescriptionController(PrescriptionService prescriptionService, PrescriptionMedicationService prescriptionMedicationService, MedicationService medicationService, DoctorService doctorService, PatientService patientService, AppointmentService appointmentService) {
//        this.prescriptionService = prescriptionService;
//        this.prescriptionMedicationService = prescriptionMedicationService;
//        this.medicationService = medicationService;
//        this.doctorService = doctorService;
//        this.patientService = patientService;
//        this.appointmentService = appointmentService;
//    }
//
//}
