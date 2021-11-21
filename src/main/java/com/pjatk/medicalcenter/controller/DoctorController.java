package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.service.DoctorService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorWithSpecializationDTO>> getDoctors(){
        return ResponseEntity.ok(doctorService.getDoctors().stream().map(DoctorWithSpecializationDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorWithSpecializationDTO> getDoctorById(@PathVariable long id){
        return ResponseEntity.ok(new DoctorWithSpecializationDTO(doctorService.getDoctorById(id)));
    }

    @GetMapping("/services")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByMedicalServiceIdAndLanguages(@RequestParam("language") String language, @RequestParam("medicalServiceId") Long medicalServiceId){
        return ResponseEntity.ok(doctorService.getDoctorsByMedicalServiceId(medicalServiceId, Doctor.Language.valueOf(language))
                .stream().map(DoctorDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<DoctorWithSpecializationDTO> addDoctor(@RequestBody DoctorDTO doctorDTO){
        Doctor createdDoctor = doctorService.addDoctor(DTOsMapper.mapDoctorDTOtoDoctor(doctorDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", createdDoctor.getId()))).build();
    }

    @PostMapping("/{doctorId}/specializations")
    public ResponseEntity<DoctorWithSpecializationDTO> addDoctorSpecialization(@PathVariable long doctorId, @RequestBody SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO){
        Doctor updatedDoctor = doctorService.addDoctorSpecializationWithSchedule(doctorId, specializationWithScheduleRequestDTO);
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @DeleteMapping("/{doctorId}/specializations")
    public ResponseEntity<DoctorWithSpecializationDTO> deleteDoctorSpecializationSchedule(@PathVariable long doctorId, @RequestBody SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO){
        Doctor updatedDoctor = doctorService.deleteDoctorSpecializationSchedules(doctorId, specializationWithScheduleRequestDTO);
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @GetMapping("/{id}/specializations")
    public ResponseEntity<List<SpecializationWithSchedulesDTO>> getDoctorSpecializations(@PathVariable long id){
        return ResponseEntity.ok(doctorService.getDoctorSpecializations(id));
    }

    @PutMapping
    public ResponseEntity<DoctorWithSpecializationDTO> updateDoctor(@RequestBody DoctorWithSpecializationDTO doctorWithSpecializationDTO){
        Doctor updatedDoctor = doctorService.updateDoctor(DTOsMapper.mapDoctorWithSpecializationDTOtoDoctor(doctorWithSpecializationDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctorById(id);
        return ResponseEntity.ok("Success");
    }

    //TODO -> update doctor's specialization, delete doctor's specialization (delete object DoctorSpecialization)
}
