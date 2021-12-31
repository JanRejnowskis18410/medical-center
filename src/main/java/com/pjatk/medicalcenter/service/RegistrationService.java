package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.RegistrationDTO;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.model.AppUser;
import com.pjatk.medicalcenter.security.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final PatientService patientService;
    private final UserService userService;

    public RegistrationService(PatientService patientService, UserService userService) {
        this.patientService = patientService;
        this.userService = userService;
    }

    public AppUser register(RegistrationDTO registrationDTO){
        Patient patient = patientService.getPatientByPeselToRegistration(registrationDTO.getPesel());
        AppUser user = new AppUser();
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setPerson(patient);
        user.setRole(AppRole.PATIENT);
        userService.addUser(user);
        return userService.getUserByEmail(registrationDTO.getEmail());
    }
}
