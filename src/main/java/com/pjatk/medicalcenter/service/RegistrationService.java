package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.RegistrationDTO;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.model.AppUser;
import com.pjatk.medicalcenter.security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.pjatk.medicalcenter.util.ErrorMessages.PERSON_NOT_FOUND_ERROR_MESS;

@Service
public class RegistrationService {

    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;

    public RegistrationService(PatientService patientService, DoctorService doctorService, UserService userService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.userService = userService;
    }

    public AppUser register(RegistrationDTO registrationDTO){
        Patient patient = patientService.getPatientByPeselToRegistration(registrationDTO.getPesel());
        Doctor doctor = doctorService.getDoctorByPeselToRegistration(registrationDTO.getPesel());

        AppUser user = new AppUser();

        if(patient != null) {
            user.setPerson(patient);
            user.setRole(AppRole.PATIENT);
        } else if (doctor != null) {
            user.setPerson(doctor);
            user.setRole(AppRole.DOCTOR);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,PERSON_NOT_FOUND_ERROR_MESS);
        }
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        userService.addUser(user);

        return userService.getUserByEmail(registrationDTO.getEmail());
    }
}
