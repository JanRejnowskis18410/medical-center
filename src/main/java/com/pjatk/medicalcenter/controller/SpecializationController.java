package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.model.Specialization;
import com.pjatk.medicalcenter.service.SpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/specializations")
public class SpecializationController {

    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping
    public ResponseEntity<List<Specialization>> getSpecializations(){
        return ResponseEntity.ok(specializationService.getSpecializations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecializationById(@PathVariable long id){
        return ResponseEntity.ok(specializationService.getSpecializationById(id));
    }

    @PostMapping
    public ResponseEntity<Specialization> addSpecialization(@RequestBody Specialization Specialization){
        Specialization createdSpecialization = specializationService.addSpecialization(Specialization);
        return ResponseEntity.created(URI.create(String.format("/specializations/%d", createdSpecialization.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Specialization> updateSpecialization(@RequestBody Specialization Specialization){
        Specialization updatedSpecialization = specializationService.updateSpecialization(Specialization);
        return ResponseEntity.created(URI.create(String.format("/specializations/%d", updatedSpecialization.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialization(@PathVariable long id){
        specializationService.deleteSpecializationById(id);
        return ResponseEntity.ok("Success");
    }
}
