package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.SpecializationWithScheduleRequestDTO;
import com.pjatk.medicalcenter.dto.SpecializationWithSchedulesDTO;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.*;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;
    private final SpecializationRepository specializationRepository;
    private final ScheduleRepository scheduleRepository;
    private final MedicalServiceRepository medicalServiceRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentCheckUpRepository appointmentCheckUpRepository;

    public DoctorService(DoctorRepository doctorRepository, DoctorSpecializationRepository doctorSpecializationRepository, SpecializationRepository specializationRepository, ScheduleRepository scheduleRepository, MedicalServiceRepository medicalServiceRepository, AppointmentRepository appointmentRepository, AppointmentCheckUpRepository appointmentCheckUpRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorSpecializationRepository = doctorSpecializationRepository;
        this.specializationRepository = specializationRepository;
        this.scheduleRepository = scheduleRepository;
        this.medicalServiceRepository = medicalServiceRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(long id){
        return doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor does not exists"));
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor){
        if(doctorRepository.findById(doctor.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists")) != null)
            return doctorRepository.save(doctor);

        return null;
    }

    public void deleteDoctorById(long id){
        doctorRepository.delete(doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor does not exists")));
    }

    public Doctor addDoctorSpecializationWithSchedule(long doctorId, SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        Specialization specialization = specializationRepository
                .findById(specializationWithScheduleRequestDTO.getSpecializationId()).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists"));
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
        doctorSpecialization.setSpecialization(specialization);
        doctorSpecialization.setDoctor(doctor);
        doctorSpecializationRepository.save(doctorSpecialization);
        if(specializationWithScheduleRequestDTO.getSchedules() != null && specializationWithScheduleRequestDTO.getSchedules().size() > 0) {
            doctorSpecialization.addSchedules(specializationWithScheduleRequestDTO.getSchedules().stream().map(DTOsMapper::mapScheduleDTOtoSchedule).collect(Collectors.toList()));
            scheduleRepository.saveAll(doctorSpecialization.getSchedules());
        }
        doctorSpecializationRepository.save(doctorSpecialization);

        return doctor;
    }

    public List<SpecializationWithSchedulesDTO> getDoctorSpecializations(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));
        List<SpecializationWithSchedulesDTO> specializationWithSchedulesDTOS = new ArrayList<>();
        doctor.getDoctorSpecializations().forEach(docSpec ->
                specializationWithSchedulesDTOS.add(new SpecializationWithSchedulesDTO(docSpec)));

        return specializationWithSchedulesDTOS;
    }

    public List<Doctor> getDoctorsByMedicalServiceIdAndLanguage(long serviceId, Doctor.Language language) {
        MedicalService medicalService = medicalServiceRepository.findById(serviceId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Service does not exists"));
        return doctorRepository.findDoctorsByMedicalServiceIdAndLanguage(serviceId,language.toString());
    }

    public List<Doctor> getDoctorsBySpecializationId(long specializationId) {
        Specialization specialization = specializationRepository.findById(specializationId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization does not exists"));
        return doctorRepository.findDoctorsBySpecializationId(specializationId);
    }

    public List<Schedule> getDoctorsSchedules(long doctorId, long specializationId) {
        return getDoctorById(doctorId).getDoctorSpecializations().stream()
                .filter(s -> s.getSpecialization().getId().equals(specializationId))
                .map(DoctorSpecialization::getSchedules)
                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Specialization not found for this doctor"));
    }

    public Page<Appointment> getDoctorsTodaysVisit(long id, Pageable paging) {
        LocalDate today = LocalDate.now();
        return appointmentRepository.findAppointmentsByDoctorIdAndDateBetween(id, today.atStartOfDay(), today.atTime(LocalTime.MAX), paging);
    }


    public List<AppointmentCheckUp> getDoctorsAppointmentWithCheckupsWithoutResult(long doctorId){
        return getDoctorById(doctorId)
                .getAppointments()
                .stream()
                .flatMap(app -> app.getAppointmentCheckUps().stream())
                .filter(appCh -> appCh.getResult()==null && appCh.getAppointment().getState().equals(Appointment.AppointmentState.DONE))
                .collect(Collectors.toList());

    }

//    public Page<AppointmentCheckUp> getDoctorsAppointmentsWithCheckupsWithoutResult(long id, Pageable paging) {
//        return appointmentCheckUpRepository.findDoctorAppointmentCheckUpsWithoutResult(id, paging)
//    }
}
