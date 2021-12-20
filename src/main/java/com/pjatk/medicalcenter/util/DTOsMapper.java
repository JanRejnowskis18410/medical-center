package com.pjatk.medicalcenter.util;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DTOsMapper {

    public static Patient mapPatientDTOtoPatient(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
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

    public static Doctor mapDoctorWithSpecializationDTOtoDoctor(DoctorWithSpecializationDTO doctorWithSpecializationDTO){
        Doctor doctor = new Doctor();
        doctor.setId(doctorWithSpecializationDTO.getId());
        doctor.setFirstName(doctorWithSpecializationDTO.getFirstName());
        doctor.setLastName(doctorWithSpecializationDTO.getLastName());
        doctor.setEmail(doctorWithSpecializationDTO.getEmail());
        doctor.setBirthDate(doctorWithSpecializationDTO.getBirthDate());
        doctor.setPesel(doctorWithSpecializationDTO.getPesel());
        doctor.setPWZ(doctorWithSpecializationDTO.getPWZ());
        doctor.getLanguages().addAll(doctorWithSpecializationDTO.getLanguages());

        List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();
        for (SpecializationWithSchedulesDTO specializationWithSchedulesDTO : doctorWithSpecializationDTO.getSpecializationWithSchedules()) {
            Specialization specialization = new Specialization();
            specialization.setId(specializationWithSchedulesDTO.getId());
            specialization.setName(specializationWithSchedulesDTO.getName());

            DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
            doctorSpecialization.setSchedules(specializationWithSchedulesDTO.getSchedules().stream().map(DTOsMapper::mapScheduleDTOtoSchedule).collect(Collectors.toList()));
            doctorSpecializations.add(doctorSpecialization);
        }
        doctor.setDoctorSpecializations(doctorSpecializations);

        return doctor;
    }

    public static Doctor mapDoctorDTOtoDoctor(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setBirthDate(doctorDTO.getBirthDate());
        doctor.setPesel(doctorDTO.getPesel());
        doctor.setPWZ(doctorDTO.getPWZ());
        doctor.getLanguages().addAll(doctorDTO.getLanguages());

        return doctor;
    }

    public static Specialization mapSpecializationDTOtoSpecialization(SpecializationDTO specializationDTO) {
        Specialization specialization = new Specialization();
        specialization.setId(specializationDTO.getId());
        specialization.setName(specializationDTO.getName());

        return specialization;
    }

    public static DoctorSpecialization mapDoctorSpecializationDTOtoDoctorSpecialization(DoctorSpecializationDTO doctorSpecializationDTO){
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization();
        doctorSpecialization.setSpecialization(DTOsMapper.mapSpecializationDTOtoSpecialization(doctorSpecializationDTO.getSpecialization()));
        doctorSpecialization.setDoctor(DTOsMapper.mapDoctorDTOtoDoctor(doctorSpecializationDTO.getDoctor()));
        doctorSpecialization.setSchedules(doctorSpecializationDTO.getSchedules());

        return doctorSpecialization;
    }

    public static Schedule mapScheduleDTOtoSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        if(scheduleDTO.getId()!=0)
            schedule.setId(scheduleDTO.getId());
        schedule.setDayOfWeek(scheduleDTO.getDayOfWeek());
        schedule.setDateFrom(scheduleDTO.getDateFrom());
        schedule.setDateTo(scheduleDTO.getDateTo());

        return schedule;
    }

    public static MedicalService mapServiceDTOToService(MedicalServiceDTO medicalServiceDTO) {
        MedicalService medicalService = new MedicalService();
        medicalService.setId(medicalServiceDTO.getId());
        medicalService.setName(medicalServiceDTO.getName());
        medicalService.setFacilityService(medicalServiceDTO.getFacilityService());
        medicalService.setDoneByMedicalStaff(medicalServiceDTO.getDoneByMedicalStaff());
        return medicalService;
    }

    public static MedicalService mapCreateServiceDTOToService(CreateMedicalServiceDTO createMedicalServiceDTO) {
        MedicalService medicalService = new MedicalService();
        medicalService.setId(createMedicalServiceDTO.getId());
        medicalService.setName(createMedicalServiceDTO.getName());
        medicalService.setFacilityService(createMedicalServiceDTO.isFacilityService());
        medicalService.setDoneByMedicalStaff(createMedicalServiceDTO.isDoneByMedicalStaff());
        return medicalService;
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

//    public static PatientsDoneVisitDTO mapAppointmentToPatientsDoneVisitDTO(Appointment apmt){
//        PatientsDoneVisitDTO patientsDoneVisitDTO = new PatientsDoneVisitDTO();
//        patientsDoneVisitDTO.setServiceName(apmt.getMedicalService().getName());
//        patientsDoneVisitDTO.setDoctor(new DoctorDTO(apmt.getDoctor()));
//        patientsDoneVisitDTO.setDate(apmt.getDate());
//        patientsDoneVisitDTO.setRecommendations(apmt.getRecommendations());
//        patientsDoneVisitDTO.setType(apmt.getType());
//        patientsDoneVisitDTO.setIssuedReferrals(apmt.getIssuedReferrals().stream()
//                                                    .map(ReferralDTO::new)
//                                                    .collect(Collectors.toList()));
//        patientsDoneVisitDTO.setPrescriptions(apmt.getPrescriptions().stream()
//                                                .map(PrescriptionDTO::new)
//                                                .collect(Collectors.toList()));
//        patientsDoneVisitDTO.setDiagnosticTests(apmt.);
//        }
//    }
}
