package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AppointmentDTO;
import com.pjatk.medicalcenter.dto.PatientDTO;
import com.pjatk.medicalcenter.dto.PatientsFileDTO;
import com.pjatk.medicalcenter.dto.ReferralDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.model.PatientsFile;
import com.pjatk.medicalcenter.model.Referral;
import com.pjatk.medicalcenter.service.PatientService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getPatients(){
        List<Patient> patients = patientService.getPatients();
        return ResponseEntity.ok(patients.stream().map(PatientDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable long id){
        return ResponseEntity.ok(new PatientDTO(patientService.getPatientById(id)));
    }

    @GetMapping("/{patientId}/files")
    public ResponseEntity<List<PatientsFileDTO>> getPatientsFiles(@PathVariable long patientId){
        List<PatientsFile> patientsFiles = patientService.getPatientsFile(patientId);
        return ResponseEntity.ok(patientsFiles.stream().map(PatientsFileDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/files/{fileId}")
    public ResponseEntity<PatientsFileDTO> getPatientsFileById(@PathVariable long patientId, @PathVariable long fileId){
        return ResponseEntity.ok(new PatientsFileDTO(patientService.getPatientsFileById(patientId,fileId)));
    }

    @GetMapping("/{patientId}/appointments")
    public ResponseEntity<List<AppointmentDTO>> getPatientsAppointments(@PathVariable long patientId){
        List<Appointment> appointments = patientService.getPatientsAppointments(patientId);
        return ResponseEntity.ok(appointments.stream().map(AppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{patientId}/referrals")
    public ResponseEntity<List<ReferralDTO>> getAvailablePatientsReferrals(@PathVariable long patientId) {
        List<Referral> referrals = patientService.getAvailablePatientsReferrals(patientId);
        return ResponseEntity.ok(referrals.stream().map(ReferralDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDTO patientDTO){
        Patient createdPatient = patientService.addPatient(DTOsMapper.mapPatientDTOtoPatient(patientDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d", createdPatient.getId()))).build();
    }
    @PostMapping("/{id}/files")
    public ResponseEntity<Patient> addPatientsFile(@PathVariable long id, @RequestBody PatientsFileDTO patientsFileDTO){
        PatientsFile createdPatientsFile = patientService.addPatientsFile(id,DTOsMapper.mapPatientFileDTOtoPatientFile(patientsFileDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d/files/%d",id,createdPatientsFile.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody PatientDTO patientDTO){
        Patient updatedPatient = patientService.updatePatient(DTOsMapper.mapPatientDTOtoPatient(patientDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d", updatedPatient.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable long id){
        patientService.deletePatientById(id);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllPatients(){
        patientService.deleteAllPatients();
        return ResponseEntity.ok("Success");
    }
}
