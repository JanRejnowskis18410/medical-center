package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.AvailableAppointmentsRequestDTO;
import com.pjatk.medicalcenter.dto.CreateAppointmentDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.repository.AppointmentRepository;
import com.pjatk.medicalcenter.specifications.AppointmentSpecification;
import com.pjatk.medicalcenter.specifications.AppointmentSpecificationBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final MedicalServiceService medicalServiceService;
    private final DoctorService doctorService;

    public AppointmentService(AppointmentRepository appointmentRepository, MedicalServiceService medicalServiceService, DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.medicalServiceService = medicalServiceService;
        this.doctorService = doctorService;
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Page<Appointment> getAvailableAppointments(AvailableAppointmentsRequestDTO availableAppointmentsRq, Pageable paging) {

        AppointmentSpecificationBuilder appointmentSpecificationBuilder = new AppointmentSpecificationBuilder();

        if(Objects.nonNull(medicalServiceService.getServiceById(availableAppointmentsRq.getMedicalServiceId()))) {
            appointmentSpecificationBuilder
                    .addSpecification(AppointmentSpecification.medicalServiceIdEqualTo(availableAppointmentsRq.getMedicalServiceId()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getDoctorId()) && Objects.nonNull(doctorService.getDoctorById(availableAppointmentsRq.getDoctorId()))) {
            appointmentSpecificationBuilder
                    .addSpecification(AppointmentSpecification.doctorIdEqualTo(availableAppointmentsRq.getDoctorId()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getDateFrom())) {
            appointmentSpecificationBuilder
                    .addSpecification(AppointmentSpecification.dateGreaterThanOrEqual(availableAppointmentsRq.getDateFrom()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getDateTo())) {
            appointmentSpecificationBuilder
                    .addSpecification(AppointmentSpecification.dateLessThanOrEqual(availableAppointmentsRq.getDateTo()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getLanguage())){
            appointmentSpecificationBuilder
                    .addSpecification(AppointmentSpecification.languageEqual(availableAppointmentsRq.getLanguage()));
        }

        return appointmentRepository.findAll(appointmentSpecificationBuilder.build(), paging);
    }

    public Appointment getAppointmentById(long id){
        return appointmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment does not exists"));
    }

    public Appointment saveAppointment(CreateAppointmentDTO newAppointment) {
        Appointment appointment = mapCreateNewAppointmentToAppointment(newAppointment);
        return appointmentRepository.save(appointment);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> addAppointments(List<CreateAppointmentDTO> newAppointments) {
        List<Appointment> appointments = newAppointments
                                            .stream()
                                            .map(this::mapCreateNewAppointmentToAppointment)
                                            .collect(Collectors.toList());
        return appointmentRepository.saveAll(appointments);
    }

    public void deleteAppointmentById(long id){
        appointmentRepository.delete(appointmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment does not exists")));
    }

    private Appointment mapCreateNewAppointmentToAppointment(CreateAppointmentDTO newAppointment){
        Appointment appointment = new Appointment();

        MedicalService medicalService = medicalServiceService.getServiceById(newAppointment.getMedicalServiceId());
        if(!medicalService.isDoneByMedicalStaff()){
            if(newAppointment.getDoctorId() == null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Doctor is required");
            } else {
                Doctor doctor = doctorService.getDoctorById(newAppointment.getDoctorId());
                if(doctor.getDoctorSpecializations().stream().noneMatch(e -> e.getSpecialization().getId().equals(medicalService.getSpecialization().getId())))
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Doctor cannot be assign to this service");
                else
                    appointment.setDoctor(doctor);
            }
        }
        appointment.setMedicalService(medicalService);
        appointment.setDate(newAppointment.getDate());
        appointment.setType(medicalService.isFacilityService() ? Appointment.AppointmentType.FACILITY : Appointment.AppointmentType.TELEPHONE);
        appointment.setState(Appointment.AppointmentState.AVAILABLE);

        return appointment;
    }
}

