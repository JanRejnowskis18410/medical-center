package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.SpecializationWithScheduleRequestDTO;
import com.pjatk.medicalcenter.dto.SpecializationWithSchedulesDTO;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.*;
import com.pjatk.medicalcenter.security.service.AccessService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.pjatk.medicalcenter.util.ErrorMessages.*;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;
    private final SpecializationRepository specializationRepository;
    private final ScheduleRepository scheduleRepository;
    private final MedicalServiceRepository medicalServiceRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentCheckUpRepository appointmentCheckUpRepository;
    private final AccessService accessService;

    public DoctorService(DoctorRepository doctorRepository, DoctorSpecializationRepository doctorSpecializationRepository, SpecializationRepository specializationRepository, ScheduleRepository scheduleRepository, MedicalServiceRepository medicalServiceRepository, AppointmentRepository appointmentRepository, AppointmentCheckUpRepository appointmentCheckUpRepository, AccessService accessService) {
        this.doctorRepository = doctorRepository;
        this.doctorSpecializationRepository = doctorSpecializationRepository;
        this.specializationRepository = specializationRepository;
        this.scheduleRepository = scheduleRepository;
        this.medicalServiceRepository = medicalServiceRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
        this.accessService = accessService;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(long id){
        return doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,DOCTOR_NOT_FOUND_ERROR_MESS));
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor){
        if(doctorRepository.findById(doctor.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, DOCTOR_NOT_FOUND_ERROR_MESS)) != null)
            return doctorRepository.save(doctor);

        return null;
    }

    public void deleteDoctorById(long id){
        doctorRepository.delete(doctorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,DOCTOR_NOT_FOUND_ERROR_MESS)));
    }

    public Doctor addDoctorSpecializationWithSchedule(long doctorId, SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, DOCTOR_NOT_FOUND_ERROR_MESS));
        Specialization specialization = specializationRepository
                .findById(specializationWithScheduleRequestDTO.getSpecializationId()).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, SPECIALIZATION_NOT_FOUND_ERROR_MESS));
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor,specialization);
        doctorSpecialization.setSpecialization(specialization);
        doctorSpecialization.setDoctor(doctor);
        doctorSpecializationRepository.save(doctorSpecialization);
        if(specializationWithScheduleRequestDTO.getSchedules() != null && !specializationWithScheduleRequestDTO.getSchedules().isEmpty()) {
            doctorSpecialization.addSchedules(specializationWithScheduleRequestDTO.getSchedules().stream().map(DTOsMapper::mapScheduleDTOtoSchedule).collect(Collectors.toList()));
            scheduleRepository.saveAll(doctorSpecialization.getSchedules());
        }
        doctorSpecializationRepository.save(doctorSpecialization);

        return doctor;
    }

    public List<SpecializationWithSchedulesDTO> getDoctorSpecializations(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, DOCTOR_NOT_FOUND_ERROR_MESS));
        List<SpecializationWithSchedulesDTO> specializationWithSchedulesDTOS = new ArrayList<>();
        doctor.getDoctorSpecializations().forEach(docSpec ->
                specializationWithSchedulesDTOS.add(new SpecializationWithSchedulesDTO(docSpec)));

        return specializationWithSchedulesDTOS;
    }

    public List<Doctor> getDoctorsByMedicalServiceIdAndLanguage(long serviceId, Doctor.Language language) {
        medicalServiceRepository.findById(serviceId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, SERVICE_NOT_FOUND_ERROR_MESS));
        return doctorRepository.findDoctorsByMedicalServiceIdAndLanguage(serviceId,language.toString());
    }

    public List<Doctor> getDoctorsBySpecializationId(long specializationId) {
        specializationRepository.findById(specializationId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, SPECIALIZATION_NOT_FOUND_ERROR_MESS));
        return doctorRepository.findDoctorsBySpecializationId(specializationId);
    }

    public List<Schedule> getDoctorsSchedules(long doctorId, long specializationId) {
        return getDoctorById(doctorId).getDoctorSpecializations().stream()
                .filter(s -> s.getSpecialization().getId().equals(specializationId))
                .map(DoctorSpecialization::getSchedules)
                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,SPECIALIZATION_FOR_DOCTOR_NOT_FOUND_ERROR_MESS));
    }

    public Page<Appointment> getDoctorsTodaysVisit(long id, Pageable paging, Authentication auth) {
        accessService.authenticatePerson(auth, id);
        LocalDate today = LocalDate.now();
        return appointmentRepository.findAppointmentsByDoctorIdAndDateBetween(id, today.atStartOfDay(), today.atTime(LocalTime.MAX), paging);
    }

    public Page<AppointmentCheckUp> getDoctorsAppointmentsWithCheckupsWithoutResult(long id, Pageable paging, Authentication auth) {
        accessService.authenticatePerson(auth, id);
        return appointmentCheckUpRepository.findDoctorAppointmentCheckUpsWithoutResult(id, paging);
    }

    public Doctor getDoctorByPeselToRegistration(String pesel) {
        Doctor doctor = doctorRepository.findByPesel(pesel);
        if(!Objects.isNull(doctor) && !Objects.isNull(doctor.getUser())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,USER_ALREADY_EXISTS_ERROR_MESS);
        }
        return doctor;
    }
}
