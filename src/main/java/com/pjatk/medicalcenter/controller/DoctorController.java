package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.AddSpecializationWithScheduleDTO;
import com.pjatk.medicalcenter.dto.DoctorDTO;
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
    public ResponseEntity<List<DoctorDTO>> getDoctors(){
        return ResponseEntity.ok(doctorService.getDoctors().stream().map(DoctorDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable long id){
        return ResponseEntity.ok(new DoctorDTO(doctorService.getDoctorById(id)));
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO){
        Doctor createdDoctor = doctorService.addDoctor(DTOsMapper.mapDoctorDTOtoDoctor(doctorDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", createdDoctor.getId()))).build();
    }

    @PostMapping("/{doctorId}/specializations")
    public ResponseEntity<DoctorDTO> addDoctorSpecialization(@PathVariable long doctorId, @RequestBody AddSpecializationWithScheduleDTO addSpecializationWithScheduleDTO){
        Doctor updatedDoctor = doctorService.addDoctorSpecializationWithSchedule(doctorId, addSpecializationWithScheduleDTO);
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @GetMapping("/{id}/specializations")
    public ResponseEntity<List<SpecializationDTO>> getDoctorSpecializations(@PathVariable long id){
        return ResponseEntity.ok(doctorService.getDoctorSpecializations(id));
    }

    @PutMapping
    public ResponseEntity<DoctorDTO> updateDoctor(@RequestBody DoctorDTO doctorDTO){
        Doctor updatedDoctor = doctorService.updateDoctor(DTOsMapper.mapDoctorDTOtoDoctor(doctorDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctorById(id);
        return ResponseEntity.ok("Success");
    }
}
