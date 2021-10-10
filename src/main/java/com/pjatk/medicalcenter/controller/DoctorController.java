package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AddSpecializationWithScheduleDTO;
import com.pjatk.medicalcenter.dto.DoctorWithSpecializationDTO;
import com.pjatk.medicalcenter.dto.SpecializationDTO;
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

    @PostMapping
    public ResponseEntity<DoctorWithSpecializationDTO> addDoctor(@RequestBody DoctorWithSpecializationDTO doctorWithSpecializationDTO){
        Doctor createdDoctor = doctorService.addDoctor(DTOsMapper.mapDoctorWithSpecializationDTOtoDoctor(doctorWithSpecializationDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", createdDoctor.getId()))).build();
    }

    @PostMapping("/{doctorId}/specializations")
    public ResponseEntity<DoctorWithSpecializationDTO> addDoctorSpecialization(@PathVariable long doctorId, @RequestBody AddSpecializationWithScheduleDTO addSpecializationWithScheduleDTO){
        Doctor updatedDoctor = doctorService.addDoctorSpecializationWithSchedule(doctorId, addSpecializationWithScheduleDTO);
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @GetMapping("/{id}/specializations")
    public ResponseEntity<List<SpecializationDTO>> getDoctorSpecializations(@PathVariable long id){
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
}
