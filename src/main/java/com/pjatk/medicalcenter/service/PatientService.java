package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.*;

import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.service.AccessService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.pjatk.medicalcenter.util.ErrorMessages.*;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientsFileRepository patientsFileRepository;
    private final ReferralRepository referralRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentCheckUpRepository appointmentCheckUpRepository;
    private final AccessService accessService;

    public PatientService(PatientRepository patientRepository, PatientsFileRepository patientsFileRepository, ReferralRepository referralRepository, AppointmentRepository appointmentRepository, AppointmentCheckUpRepository appointmentCheckUpRepository, AccessService accessService) {
        this.patientRepository = patientRepository;
        this.patientsFileRepository = patientsFileRepository;
        this.referralRepository = referralRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
        this.accessService = accessService;
    }

    public Patient getPatientById(long id){
        return patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,PATIENT_NOT_FOUND_ERROR_MESS));
    }

    public Patient getPatientById(long id, Authentication auth){
        accessService.authenticatePerson(auth,id);
        return patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,PATIENT_NOT_FOUND_ERROR_MESS));
    }

    public Patient getPatientByPeselToRegistration(String pesel) {
        Patient patient = patientRepository.findByPesel(pesel).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,PATIENT_NOT_FOUND_ERROR_MESS));
        if(!Objects.isNull(patient.getUser())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,USER_ALREADY_EXISTS_ERROR_MESS);
        }
        return patient;
    }

    public Patient updatePatient(Patient patient, Authentication auth){
        accessService.authenticatePerson(auth, patient.getId());
        if(patientRepository.findById(patient.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,PATIENT_NOT_FOUND_ERROR_MESS)) != null)
            return patientRepository.save(patient);

        return null;
    }

    public List<PatientsFile> getPatientsFile(long patientId, Authentication auth){
        if(accessService.checkRole(auth).equals(AppRole.PATIENT)){
            accessService.authenticatePerson(auth,patientId);
        }
        getPatientById(patientId);
        return patientsFileRepository.getPatientsFileByPatientId(patientId)
                .stream().sorted((o1, o2) -> o2.getUploadDate().compareTo(o1.getUploadDate()))
                .collect(Collectors.toList());
    }

    public Page<Appointment> getPatientsAppointments(long patientId, Pageable paging, Authentication auth) {
        if(accessService.checkRole(auth).equals(AppRole.PATIENT)){
            accessService.authenticatePerson(auth,patientId);
        }
        getPatientById(patientId);
        return appointmentRepository.findAppointmentsByPatientId(patientId, paging);
    }

    public Page<Appointment> getPatientsDoneAppointments(long patientId, Pageable paging) {
        getPatientById(patientId);
        return appointmentRepository.findAppointmentsByPatientIdAndState(patientId, Appointment.AppointmentState.DONE, paging);
    }

    // returns today's and future visits
    public List<Appointment> getPatientsPlannedAppointments(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getAppointments().stream()
                .filter(apmt -> apmt.getState().equals(Appointment.AppointmentState.RESERVED) ||
                        apmt.getState().equals(Appointment.AppointmentState.CONFIRMED))
                .sorted(Comparator.comparing(Appointment::getDate))
                .collect(Collectors.toList());
    }

    public PatientsFile getPatientsFileById(long id, long fileId, Authentication auth){
        if(accessService.checkRole(auth).equals(AppRole.PATIENT)){
            accessService.authenticatePerson(auth,id);
        }
        Patient patient = getPatientById(id);
        return patient.getPatientsFiles().stream()
                                        .filter(e -> e.getId() == fileId)
                                        .findFirst()
                                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,FILE_NOT_FOUND_ERROR_MESS));
    }

    public PatientsFile addPatientsFile(long id, PatientsFile patientsFile, Authentication auth){
        accessService.authenticatePerson(auth, id);
        patientsFile.setPatient(getPatientById(id));
        return patientsFileRepository.save(patientsFile);
    }

    public void deletePatientsFile(long patientId, long patientsFileId, Authentication auth){
        accessService.authenticatePerson(auth, patientId);
        patientsFileRepository.deleteById(patientsFileId);
    }

    public Page<Referral> getPatientsAvailableReferrals(Long id, Pageable pageable, Authentication auth) {
        accessService.authenticatePerson(auth, id);
        return referralRepository.findByPatientIdAndAppointmentIsNull(id, pageable);
    }

    public List<Prescription> getPatientsPrescriptions(long patientId, Authentication auth) {
        accessService.authenticatePerson(auth, patientId);
        Patient patient = getPatientById(patientId);
        return patient.getPrescriptions();
    }

    public Page<AppointmentCheckUp> getPatientsDiagnosticTests(long patientId, Pageable pageable, Authentication auth) {
        if(accessService.checkRole(auth).equals(AppRole.PATIENT)){
            accessService.authenticatePerson(auth,patientId);
        }
        return appointmentCheckUpRepository.findAppointmentCheckUpByAppointmentPatientIdAndResultIsNotNull(patientId, pageable);
    }
}
