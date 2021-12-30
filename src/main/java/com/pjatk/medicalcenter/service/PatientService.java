package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientsFileRepository patientsFileRepository;
    private final ReferralRepository referralRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentCheckUpRepository appointmentCheckUpRepository;

    public PatientService(PatientRepository patientRepository, PatientsFileRepository patientsFileRepository, ReferralRepository referralRepository, AppointmentRepository appointmentRepository, AppointmentCheckUpRepository appointmentCheckUpRepository) {
        this.patientRepository = patientRepository;
        this.patientsFileRepository = patientsFileRepository;
        this.referralRepository = referralRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
    }

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(long id){
        return patientRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient does not exists"));
    }

    public Patient getPatientByPesel(String pesel){
        return patientRepository.findByPesel(pesel).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient does not exists"));
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
        getPatientById(patientsId);
        return patientsFileRepository.getPatientsFileByPatientId(patientsId)
                .stream().sorted((o1, o2) -> o2.getUploadDate().compareTo(o1.getUploadDate()))
                .collect(Collectors.toList());
    }

    public Page<Appointment> getPatientsAppointments(long patientId, Pageable paging) {
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

    public Page<Referral> getPatientsAvailableReferrals(Long id, Pageable pageable) {
        return referralRepository.findByPatientIdAndAppointmentIsNull(id, pageable);
    }

    public List<Prescription> getPatientsPrescriptions(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getPrescriptions();
    }

    public Page<AppointmentCheckUp> getPatientsDiagnosticTests(long patientId, Pageable pageable) {
        return appointmentCheckUpRepository.findAppointmentCheckUpByAppointmentPatientIdAndResultIsNotNull(patientId, pageable);
    }
}
