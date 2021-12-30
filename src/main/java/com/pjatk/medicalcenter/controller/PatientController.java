package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.service.PatientService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable long id, Authentication auth){
        return ResponseEntity.ok(new PatientDTO(patientService.getPatientById(id, auth)));
    }

    @GetMapping("/{patientId}/files")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<PatientsFileDTO>> getPatientsFiles(@PathVariable long patientId, Authentication auth){
        List<PatientsFile> patientsFiles = patientService.getPatientsFile(patientId, auth);
        return ResponseEntity.ok(patientsFiles.stream().map(PatientsFileDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/files/{fileId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<PatientsFileDTO> getPatientsFileById(
            @PathVariable long patientId,
            @PathVariable long fileId,
            Authentication auth){
        return ResponseEntity.ok(new PatientsFileDTO(patientService.getPatientsFileById(patientId,fileId, auth)));
    }

    @GetMapping("/{patientId}/appointments")
    public ResponseEntity<Map<String,Object>> getPatientsAppointments(
            @PathVariable long patientId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size,
            Authentication auth){

        Pageable paging = PageRequest.of(page, size, Sort.by("date").descending());
        Page<Appointment> appointments = patientService.getPatientsAppointments(patientId, paging, auth);

        Map<String,Object> response = new HashMap<>();
        response.put("appointments", appointments.stream().map(PatientsDoneVisitDTO::new).collect(Collectors.toList()));
        response.put("currentPage", appointments.getNumber());
        response.put("totalItems", appointments.getTotalElements());
        response.put("totalPages", appointments.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{patientId}/doneAppointments")
    public ResponseEntity<Map<String,Object>> getPatientsDoneAppointments(
            @PathVariable long patientId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size,
            Authentication auth){

        Pageable paging = PageRequest.of(page, size, Sort.by("date").descending());
        Page<Appointment> doneAppointments = patientService.getPatientsDoneAppointments(patientId, paging);

        Map<String,Object> response = new HashMap<>();
        response.put("appointments", doneAppointments.stream().map(PatientsDoneVisitDTO::new).collect(Collectors.toList()));
        response.put("currentPage", doneAppointments.getNumber());
        response.put("totalItems", doneAppointments.getTotalElements());
        response.put("totalPages", doneAppointments.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{patientId}/diagnosticTests")
    public ResponseEntity<Map<String, Object>> getPatientsDiagnosticTests(
            @PathVariable long patientId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size,
            Authentication auth){

        Pageable paging = PageRequest.of(page, size, Sort.by("appointment.date").descending());
        Page<AppointmentCheckUp> diagnosticTests = patientService.getPatientsDiagnosticTests(patientId, paging, auth);

        Map<String,Object> response = new HashMap<>();
        response.put("diagnosticTests", diagnosticTests.stream().map(AppointmentCheckUpDTO::new).collect(Collectors.toList()));
        response.put("currentPage", diagnosticTests.getNumber());
        response.put("totalItems", diagnosticTests.getTotalElements());
        response.put("totalPages", diagnosticTests.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{patientId}/referrals")
    public ResponseEntity<Map<String,Object>> getAvailablePatientsReferrals(
            @PathVariable long patientId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size,
            Authentication auth) {

        Pageable paging = PageRequest.of(page, size, Sort.by("expiryDate").ascending().and(Sort.by("medicalService.name")));
        Page<Referral> referrals = patientService.getPatientsAvailableReferrals(patientId, paging, auth);

        Map<String,Object> response = new HashMap<>();
        response.put("referrals", referrals.stream().map(ReferralDTO::new).collect(Collectors.toList()));
        response.put("currentPage", referrals.getNumber());
        response.put("totalItems", referrals.getTotalElements());
        response.put("totalPages", referrals.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{patientId}/prescriptions")
    public ResponseEntity<List<PrescriptionDTO>> getPatientsPrescriptions(@PathVariable long patientId, Authentication auth) {
        List<Prescription> prescriptions = patientService.getPatientsPrescriptions(patientId, auth);
        return ResponseEntity.ok(prescriptions.stream().map(PrescriptionDTO::new).collect(Collectors.toList()));
    }

    @PostMapping("/{id}/files")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Patient> addPatientsFile(
            @PathVariable long id,
            @Valid @RequestBody PatientsFileDTO patientsFileDTO,
            Authentication auth){
        PatientsFile createdPatientsFile = patientService.addPatientsFile(id,DTOsMapper.mapPatientFileDTOtoPatientFile(patientsFileDTO), auth);
        return ResponseEntity.created(URI.create(String.format("/patients/%d/files/%d",id,createdPatientsFile.getId()))).build();
    }

    @DeleteMapping("/{id}/files/{patientsFileId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deletePatientsFile(
            @PathVariable long id,
            @PathVariable long patientsFileId,
            Authentication auth){
        patientService.deletePatientsFile(id, patientsFileId, auth);
        return ResponseEntity.ok("Success");
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Patient> updatePatient(@RequestBody PatientDTO patientDTO, Authentication auth){
        Patient updatedPatient = patientService.updatePatient(DTOsMapper.mapPatientDTOtoPatient(patientDTO), auth);
        return ResponseEntity.created(URI.create(String.format("/patients/%d", updatedPatient.getId()))).build();
    }

}
