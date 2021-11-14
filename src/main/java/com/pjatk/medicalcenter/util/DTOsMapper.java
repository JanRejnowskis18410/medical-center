package com.pjatk.medicalcenter.util;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;

import java.util.ArrayList;
import java.util.List;
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
        for(PatientsFileDTO patientsFileDTO: patientDTO.getPatientsFiles()){
            patientsFiles.add(mapPatientFileDTOtoPatientFile(patientsFileDTO));
        }
        patient.setPatientsFiles(patientsFiles);
        return patient;
    }

    public static PatientsFile mapPatientFileDTOtoPatientFile(PatientsFileDTO patientsFileDTO){
        PatientsFile patientsFile = new PatientsFile();
        patientsFile.setId(patientsFileDTO.getId());
        patientsFile.setFile(patientsFileDTO.getFile());
        patientsFile.setName(patientsFileDTO.getName());

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

//    public static Specialization mapSpecializationWithDoctorsDTOtoSpecialization(SpecializationWithDoctorsDTO specializationWithDoctorsDTO) {
//        Specialization specialization = new Specialization();
//        specialization.setId(specializationWithDoctorsDTO.getId());
//        specialization.setName(specializationWithDoctorsDTO.getName());
//
//        List<DoctorSpecialization> doctorSpecializations = new ArrayList<>();
//        for (DoctorDTO doctorDTO : specializationWithDoctorsDTO.getDoctorDTOs()) {
//            Doctor doctor = DTOsMapper.mapDoctorDTOtoDoctor(doctorDTO);
//            DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
//            doctorSpecializations.add(doctorSpecialization);
//        }
//        specialization.setDoctorSpecializations(doctorSpecializations);
//
//        return specialization;
//    }

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

//    public static Specialization SpecializationWithSchedulesDTOtoSpecialization(SpecializationWithSchedulesDTO specializationWithSchedulesDTO){
//        Specialization specialization = new Specialization();
//        specialization.setId(specializationWithSchedulesDTO.getId());
//        specialization.setName(specializationWithSchedulesDTO.getName());
//        specialization.
//    }

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
        medicalService.setFacilityService(medicalServiceDTO.isFacilityService());
        medicalService.setDoneByMedicalStaff(medicalServiceDTO.isDoneByMedicalStaff());
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

    public static AppointmentTestDTO mapAppointmentTestDTOToAppointmentTest(AppointmentCheckUp aCU){
        AppointmentTestDTO appointmentTestDTO = new AppointmentTestDTO();
        appointmentTestDTO.setAppointmentId(aCU.getAppointment().getId());
        appointmentTestDTO.setCheckUpId(aCU.getCheckUp().getId());
        appointmentTestDTO.setDiagnosticTestName(aCU.getCheckUp().getName());
        appointmentTestDTO.setResult(aCU.getResult());
        appointmentTestDTO.setDescription(aCU.getDescription());
        appointmentTestDTO.setFile(aCU.getFile());
        return appointmentTestDTO;
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
