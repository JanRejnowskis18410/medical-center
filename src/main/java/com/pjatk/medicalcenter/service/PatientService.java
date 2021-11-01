package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.PatientRepository;
import com.pjatk.medicalcenter.repository.PatientsFileRepository;

import com.pjatk.medicalcenter.repository.ReferralRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

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

    public List<Appointment> getPatientsAppointments(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getAppointments();
    }

    public PatientsFile getPatientsFileById(long id, long fileId){
        Patient patient = getPatientById(id);
        PatientsFile patientsFile = patientsFileRepository.findById(fileId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"File does not exists"));

        if(patientsFile.getPatient().getId().equals(patient.getId())){
            return patientsFile;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("File %d does not exists for patient %d",patientsFile.getId(), patient.getId()));
        }
    }
    public PatientsFile addPatientsFile(long id, PatientsFile patientsFile){
        patientsFile.setPatient(getPatientById(id));
        return patientsFileRepository.save(patientsFile);
    }

    public void deleteAllPatients() {
        patientRepository.deleteAll();
    }

    public List<Referral> getAvailablePatientsReferrals(Long id) {
        LocalDate now = LocalDate.now();
        return referralRepository.findByPatientIdAndAppointmentIsNullAndExpiryDateIsGreaterThanEqual(id, now);
    }

    public List<Prescription> getPatientsPrescriptions(long patientId) {
        Patient patient = getPatientById(patientId);
        return patient.getPrescriptions();
    }
}
