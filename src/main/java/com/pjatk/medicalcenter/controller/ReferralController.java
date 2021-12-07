package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.CreateReferralDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.model.Referral;
import com.pjatk.medicalcenter.service.AppointmentService;
import com.pjatk.medicalcenter.service.MedicalServiceService;
import com.pjatk.medicalcenter.service.PatientService;
import com.pjatk.medicalcenter.service.ReferralService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/referrals")
@CrossOrigin
public class ReferralController {

    private final ReferralService referralService;
    private final AppointmentService appointmentService;
    private final MedicalServiceService medicalServiceService;
    private final PatientService patientService;

    public ReferralController(ReferralService referralService, AppointmentService appointmentService, MedicalServiceService medicalServiceService, PatientService patientService) {
        this.referralService = referralService;
        this.appointmentService = appointmentService;
        this.medicalServiceService = medicalServiceService;
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Referral> addReferral(@RequestBody CreateReferralDTO createReferralDTO) {
        Referral createdReferral = referralService.addReferral(mapCreateReferralDTOToReferral(createReferralDTO));
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdReferral.getId()))).build();
    }

    private Referral mapCreateReferralDTOToReferral(CreateReferralDTO createReferralDTO) {
        Referral referral = new Referral();
        referral.setId(createReferralDTO.getId());
        referral.setIssueDate(LocalDate.now());
        referral.setExpiryDate(createReferralDTO.getExpiryDate());

        Patient patient = patientService.getPatientById(createReferralDTO.getPatientId());
        referral.setPatient(patient);

        MedicalService medicalService = medicalServiceService.getServiceById(createReferralDTO.getMedicalServiceId());
        referral.setMedicalService(medicalService);

        Appointment issueAppointment = appointmentService.getAppointmentById(createReferralDTO.getIssueAppointmentId());
        referral.setIssueAppointment(issueAppointment);

        return referral;
    }
}
