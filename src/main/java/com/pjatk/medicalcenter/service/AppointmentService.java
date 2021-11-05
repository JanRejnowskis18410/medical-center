package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.AvailableAppointmentsRequestDTO;
import com.pjatk.medicalcenter.dto.CreateAppointmentDTO;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.MedicalService;
import com.pjatk.medicalcenter.repository.AppointmentRepository;
import com.pjatk.medicalcenter.specifications.SpecificationFactory;
import com.pjatk.medicalcenter.specifications.GenericSpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final MedicalServiceService medicalServiceService;
    private final DoctorService doctorService;
    @Autowired
    private  SpecificationFactory<Appointment> appointmentSpecificationFactory;

    public AppointmentService(AppointmentRepository appointmentRepository, MedicalServiceService medicalServiceService, DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.medicalServiceService = medicalServiceService;
        this.doctorService = doctorService;
    }

    public List<Appointment> getAllApointments(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAvailableAppointments(AvailableAppointmentsRequestDTO availableAppointmentsRq) {

        GenericSpecificationsBuilder<Appointment> builder = new GenericSpecificationsBuilder<>();

        if(medicalServiceService.getServiceById(availableAppointmentsRq.getMedicalServiceId()) != null){
            builder.with(appointmentSpecificationFactory.isEqual("medicalService", availableAppointmentsRq.getMedicalServiceId()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getDoctorId()) && doctorService.getDoctorById(availableAppointmentsRq.getDoctorId()) != null){
            builder.with(appointmentSpecificationFactory.isEqual("doctor", availableAppointmentsRq.getDoctorId()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getDateFrom())){
            builder.with(appointmentSpecificationFactory.isGreaterThanOrEqualTo("date",availableAppointmentsRq.getDateFrom()));
        }
        if(Objects.nonNull(availableAppointmentsRq.getDateTo())){
            builder.with(appointmentSpecificationFactory.isLessThanOrEqualTo("date",availableAppointmentsRq.getDateTo()));
        }
        builder.with(appointmentSpecificationFactory.isIn("",availableAppointmentsRq.getLanguage()));

        return appointmentRepository.findAll(builder.build());
    }

    public Appointment getAppointmentById(long id){
        return appointmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment does not exists"));
    }

    public Appointment addAppointment(CreateAppointmentDTO newAppointment) {
        Appointment appointment = mapCreateNewAppointmentToAppointment(newAppointment);
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

        return appointment;
    }
}

