package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.CheckUpDTO;
import com.pjatk.medicalcenter.model.CheckUp;
import com.pjatk.medicalcenter.service.CheckUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/checkups")
@CrossOrigin
public class CheckUpController {

    private final CheckUpService checkUpService;

    public CheckUpController(CheckUpService checkUpService) {
        this.checkUpService = checkUpService;
    }

    @GetMapping
    public ResponseEntity<List<CheckUpDTO>> getCheckUps() {
        List<CheckUp> checkUps = checkUpService.getCheckUps();
        return ResponseEntity.ok(checkUps.stream().map(CheckUpDTO::new).collect(Collectors.toList()));
    }
}
