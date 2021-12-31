package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.RegistrationDTO;
import com.pjatk.medicalcenter.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegistrationDTO registrationDTO) {
        registrationService.register(registrationDTO);
        return ResponseEntity.ok().build();
    }
}
