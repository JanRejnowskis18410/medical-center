package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.SpecializationWithDoctorsDTO;
import com.pjatk.medicalcenter.service.SpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
