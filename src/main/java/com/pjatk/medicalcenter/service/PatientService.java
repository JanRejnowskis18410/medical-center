package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.PatientRepository;
import com.pjatk.medicalcenter.repository.PatientsFileRepository;

import com.pjatk.medicalcenter.repository.ReferralRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientsFileRepository patientsFileRepository;
    private final ReferralRepository referralRepository;

    public PatientService(PatientRepository patientRepository, PatientsFileRepository patientsFileRepository, ReferralRepository referralRepository) {
        this.patientRepository = patientRepository;
        this.patientsFileRepository = patientsFileRepository;
        this.referralRepository = referralRepository;
    }

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(long id){
        return patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient does not exists"));
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        if(patientRepository.findById(patient.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient does not exists")) != null)
            return patientRepository.save(patient);

        return null;
    }

    public void deletePatientById(long id){
        patientRepository.delete(patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient does not exists")));
    }

    public List<PatientsFile> getPatientsFile(long patientsId){
        Patient patient = getPatientById(patientsId);
        List<PatientsFile> patientsFiles = patientsFileRepository.getPatientsFileByPatientId(patientsId);

        return patientsFiles;
    }

    public List<Appointment> getPatientsDoneAppointments(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getAppointments().stream()
                .filter(apmt -> apmt.getState().equals(Appointment.AppointmentState.DONE))
                .collect(Collectors.toList());
    }

    // returns today's and future visits
    public List<Appointment> getPatientsPlannedAppointments(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getAppointments().stream()
                .filter(apmt -> apmt.getState().equals(Appointment.AppointmentState.RESERVED) ||
                        apmt.getState().equals(Appointment.AppointmentState.CONFIRMED))
                .collect(Collectors.toList());
    }

    public PatientsFile getPatientsFileById(long id, long fileId){
        Patient patient = getPatientById(id);
        return patient.getPatientsFiles().stream()
                                        .filter(e -> e.getId() == fileId)
                                        .findFirst()
                                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"File does not exists"));
    }

    public PatientsFile addPatientsFile(long id, PatientsFile patientsFile){
        patientsFile.setPatient(getPatientById(id));
        return patientsFileRepository.save(patientsFile);
    }

    public void deletePatientsFile(long patientsFileId){
        patientsFileRepository.deleteById(patientsFileId);
    }

    public List<Referral> getPatientsAvailableReferrals(Long id) {
        List<Referral> refferals = getPatientById(id).getReferrals()
                .stream()
                .filter(ref -> ref.getAppointment() == null)
                .collect(Collectors.toList());
        refferals.sort(Comparator.comparing(Referral::getExpiryDate));
        return refferals;
    }

    public List<Prescription> getPatientsPrescriptions(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getPrescriptions();
    }

    public List<AppointmentCheckUp> getPatientsDiagnosticTests(long patientId) {
        return getPatientsDoneAppointments(patientId).stream()
                .flatMap(app -> app.getAppointmentCheckUps().stream())
                .collect(Collectors.toList());
    }
}
