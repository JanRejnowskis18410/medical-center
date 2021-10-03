package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.PatientDTO;
import com.pjatk.medicalcenter.dto.PatientsFileDTO;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.model.PatientsFile;
import com.pjatk.medicalcenter.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
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

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDTO patientDTO){
        Patient createdPatient = patientService.addPatient(mapPatientDTOtoPatient(patientDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d", createdPatient.getId()))).build();
    }
    @PostMapping("/{id}/files")
    public ResponseEntity<Patient> addPatientsFile(@PathVariable long id, @RequestBody PatientsFileDTO patientsFileDTO){
        PatientsFile createdPatientsFile = patientService.addPatientsFile(id,mapPatientFileDTOtoPatientFile(patientsFileDTO));
        return ResponseEntity.created(URI.create(String.format("/patients/%d/files/%d",id,createdPatientsFile.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody PatientDTO patientDTO){
        Patient updatedPatient = patientService.updatePatient(mapPatientDTOtoPatient(patientDTO));
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

    //TODO move this method to other package with common used methods
    Patient mapPatientDTOtoPatient(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setPesel(patientDTO.getPesel());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setAddress(patientDTO.getAddress());

        List<PatientsFile> patientsFiles = new ArrayList<>();
        for(PatientsFileDTO patientsFileDTO: patientDTO.getPatientsFiles()){
            patientsFiles.add(mapPatientFileDTOtoPatientFile(patientsFileDTO));
        }
        patient.setPatientsFiles(patientsFiles);
        return patient;
    }

    PatientsFile mapPatientFileDTOtoPatientFile(PatientsFileDTO patientsFileDTO){
        PatientsFile patientsFile = new PatientsFile();
        patientsFile.setId(patientsFileDTO.getId());
        patientsFile.setFile(patientsFileDTO.getFile());
        patientsFile.setName(patientsFileDTO.getName());

        return patientsFile;
    }
}
