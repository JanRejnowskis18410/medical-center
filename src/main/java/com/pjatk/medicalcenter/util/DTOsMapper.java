package com.pjatk.medicalcenter.util;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DTOsMapper {

    private DTOsMapper(){}

    public static Patient mapPatientDTOtoPatient(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setPesel(patientDTO.getPesel());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setAddress(patientDTO.getAddress());

        List<PatientsFile> patientsFiles = new ArrayList<>();
        if(Objects.nonNull(patientDTO.getPatientsFiles())) {
            for (PatientsFileDTO patientsFileDTO : patientDTO.getPatientsFiles()) {
                patientsFiles.add(mapPatientFileDTOtoPatientFile(patientsFileDTO));
            }
        }
        patient.setPatientsFiles(patientsFiles);
        return patient;
    }

    public static PatientsFile mapPatientFileDTOtoPatientFile(PatientsFileDTO patientsFileDTO){
        PatientsFile patientsFile = new PatientsFile();
        patientsFile.setId(patientsFileDTO.getId());
        patientsFile.setFile(patientsFileDTO.getFile());
        patientsFile.setName(patientsFileDTO.getName());
        patientsFile.setType(patientsFileDTO.getType());
        patientsFile.setDescription(patientsFileDTO.getDescription());
        return patientsFile;
    }

    public static Doctor mapDoctorDTOtoDoctor(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setBirthDate(doctorDTO.getBirthDate());
        doctor.setPesel(doctorDTO.getPesel());
        doctor.setPwz(doctorDTO.getPwz());
        doctor.getLanguages().addAll(doctorDTO.getLanguages());

        return doctor;
    }

    public static Specialization mapSpecializationDTOtoSpecialization(SpecializationDTO specializationDTO) {
        Specialization specialization = new Specialization();
        specialization.setId(specializationDTO.getId());
        specialization.setName(specializationDTO.getName());

        return specialization;
    }

    public static Schedule mapScheduleDTOtoSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        if(scheduleDTO.getId()!=0)
            schedule.setId(scheduleDTO.getId());
        schedule.setDateFrom(scheduleDTO.getDateFrom());
        schedule.setDateTo(scheduleDTO.getDateTo());

        return schedule;
    }


    public static AppointmentCheckUpDTO mapAppointmentTestDTOToAppointmentTest(AppointmentCheckUp aCU){
        AppointmentCheckUpDTO appointmentCheckUpDTO = new AppointmentCheckUpDTO();
        appointmentCheckUpDTO.setAppointmentId(aCU.getAppointment().getId());
        appointmentCheckUpDTO.setAppointmentDate(aCU.getAppointment().getDate());
        appointmentCheckUpDTO.setCheckUpId(aCU.getCheckUp().getId());
        appointmentCheckUpDTO.setDiagnosticTestName(aCU.getCheckUp().getName());
        appointmentCheckUpDTO.setResult(aCU.getResult());
        appointmentCheckUpDTO.setDoctorsDescription(aCU.getDoctorsDescription());
        appointmentCheckUpDTO.setFile(aCU.getFile());
        appointmentCheckUpDTO.setPatient(new PatientDTO(aCU.getAppointment().getPatient()));
        return appointmentCheckUpDTO;
    }
}
