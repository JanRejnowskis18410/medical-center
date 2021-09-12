package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient createdPatient = patientService.addPatient(patient);
        return ResponseEntity.created(URI.create(String.format("patients/%d",createdPatient.getId()))).build();
    }

}
