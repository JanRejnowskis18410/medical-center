package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.service.PatientService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<PatientDTO>> getPatients(){
        List<Patient> patients = patientService.getPatients();
        return ResponseEntity.ok(patients.stream().map(PatientDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable long id){
        return ResponseEntity.ok(new PatientDTO(patientService.getPatientById(id)));
    }

    @GetMapping("/{patientId}/files")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<PatientsFileDTO>> getPatientsFiles(@PathVariable long patientId){
        List<PatientsFile> patientsFiles = patientService.getPatientsFile(patientId);
        return ResponseEntity.ok(patientsFiles.stream().map(PatientsFileDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/files/{fileId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<PatientsFileDTO> getPatientsFileById(@PathVariable long patientId, @PathVariable long fileId){
        return ResponseEntity.ok(new PatientsFileDTO(patientService.getPatientsFileById(patientId,fileId)));
    }

    @GetMapping("/{patientId}/doneAppointments")
    public ResponseEntity<List<PatientsDoneVisitDTO>> getPatientsDoneAppointments(@PathVariable long patientId){
        List<Appointment> appointments = patientService.getPatientsDoneAppointments(patientId);
        return ResponseEntity.ok(appointments.stream().map(PatientsDoneVisitDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/plannedAppointments")
    public ResponseEntity<List<AvailableAppointmentDTO>> getPatientsPlannedAppointments(@PathVariable long patientId){
        List<Appointment> appointments = patientService.getPatientsPlannedAppointments(patientId);
        return ResponseEntity.ok(appointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/diagnosticTests")
    public ResponseEntity<List<AppointmentTestDTO>> getPatientsDiagnosticTests(@PathVariable long patientId){
        List<AppointmentCheckUp> appointments = patientService.getPatientsDiagnosticTests(patientId);
        return ResponseEntity.ok(appointments.stream().map(AppointmentTestDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/referrals")
    public ResponseEntity<List<ReferralDTO>> getAvailablePatientsReferrals(@PathVariable long patientId) {
        List<Referral> referrals = patientService.getPatientsAvailableReferrals(patientId);
        return ResponseEntity.ok(referrals.stream().map(ReferralDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/prescriptions")
    public ResponseEntity<List<PrescriptionDTO>> getPatientsPrescriptions(@PathVariable long patientId) {
        List<Prescription> prescriptions = patientService.getPatientsPrescriptions(patientId);
        return ResponseEntity.ok(prescriptions.stream().map(PrescriptionDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody PatientDTO patientDTO){
        Patient createdPatient = patientService.addPatient(DTOsMapper.mapPatientDTOtoPatient(patientDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d", createdPatient.getId()))).build();
    }
    @PostMapping("/{id}/files")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Patient> addPatientsFile(@PathVariable long id, @Valid @RequestBody PatientsFileDTO patientsFileDTO){
        PatientsFile createdPatientsFile = patientService.addPatientsFile(id,DTOsMapper.mapPatientFileDTOtoPatientFile(patientsFileDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d/files/%d",id,createdPatientsFile.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody PatientDTO patientDTO){
        Patient updatedPatient = patientService.updatePatient(DTOsMapper.mapPatientDTOtoPatient(patientDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d", updatedPatient.getId()))).build();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deletePatient(@PathVariable long id){
        patientService.deletePatientById(id);
        return ResponseEntity.ok("Success");
    }
}
