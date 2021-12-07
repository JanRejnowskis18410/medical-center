package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.SpecializationDTO;
import com.pjatk.medicalcenter.dto.SpecializationWithDoctorsDTO;
import com.pjatk.medicalcenter.model.Specialization;
import com.pjatk.medicalcenter.service.SpecializationService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/specializations")
@CrossOrigin
public class SpecializationController {

    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SpecializationWithDoctorsDTO>> getSpecializations(){
        return ResponseEntity.ok(specializationService.getSpecializations().stream().map(SpecializationWithDoctorsDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SpecializationWithDoctorsDTO> getSpecializationById(@PathVariable long id){
        return ResponseEntity.ok(new SpecializationWithDoctorsDTO(specializationService.getSpecializationById(id)));
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SpecializationDTO> addSpecialization(@RequestBody SpecializationDTO specializationDTO){
        Specialization createdSpecialization = specializationService.addSpecialization(DTOsMapper.mapSpecializationDTOtoSpecialization(specializationDTO));
        return ResponseEntity.created(URI.create(String.format("/specializations/%d", createdSpecialization.getId()))).build();
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SpecializationDTO> updateSpecialization(@RequestBody SpecializationDTO specializationDTO){
        Specialization updatedSpecialization = specializationService.updateSpecialization(DTOsMapper.mapSpecializationDTOtoSpecialization(specializationDTO));
        return ResponseEntity.created(URI.create(String.format("/specializations/%d", updatedSpecialization.getId()))).build();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deleteSpecialization(@PathVariable long id){
        specializationService.deleteSpecializationById(id);
        return ResponseEntity.ok("Success");
    }
}
