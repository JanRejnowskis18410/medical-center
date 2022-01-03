package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.repository.AppointmentRepository;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.service.AccessService;
import com.pjatk.medicalcenter.specifications.AppointmentSpecification;
import com.pjatk.medicalcenter.specifications.AppointmentSpecificationBuilder;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.pjatk.medicalcenter.util.ErrorMessages.*;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final MedicalServiceService medicalServiceService;
    private final MedicationService medicationService;
    private final CheckUpService checkUpService;
    private final DoctorService doctorService;
    private final ReferralService referralService;
    private final PrescriptionService prescriptionService;
    private final AppointmentCheckUpService appointmentCheckUpService;
    private final AccessService accessService;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              MedicalServiceService medicalServiceService,
                              MedicationService medicationService,
                              CheckUpService checkUpService,
                              DoctorService doctorService,
                              ReferralService referralService,
                              PrescriptionService prescriptionService,
                              AppointmentCheckUpService appointmentCheckUpService,
                              AccessService accessService) {
        this.appointmentRepository = appointmentRepository;
        this.medicalServiceService = medicalServiceService;
        this.medicationService = medicationService;
        this.checkUpService = checkUpService;
        this.doctorService = doctorService;
        this.referralService = referralService;
        this.prescriptionService = prescriptionService;
        this.appointmentCheckUpService = appointmentCheckUpService;
        this.accessService = accessService;
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

        appointmentSpecificationBuilder
                .addSpecification(AppointmentSpecification.appointmentStateEqualTo(Appointment.AppointmentState.AVAILABLE));

        return appointmentRepository.findAll(appointmentSpecificationBuilder.build(), paging);
    }

    public Appointment getAppointmentById(long id){
        return appointmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,APPOINTMENT_NOT_FOUND_ERROR_MESS));
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

    public void confirmTodaysAppointment(){
        List<Appointment> appointments = appointmentRepository.findAppointmentsByPatientIsNotNullAndDateAndState(LocalDate.now());
        appointments.forEach(appointment -> appointment.setState(Appointment.AppointmentState.CONFIRMED));
        appointmentRepository.saveAll(appointments);
    }

    public void confirmAppointment(long id, Authentication auth) {
        Appointment appointment = getAppointmentById(id);

        accessService.authenticatePerson(auth, appointment.getPatient().getId());

        appointment.setState(Appointment.AppointmentState.CONFIRMED);
        saveAppointment(appointment);
    }

    public void endVisit(long id, DoneAppointmentDTO doneAppointmentDTO, Authentication auth){
        Appointment appointment = getAppointmentById(id);

        accessService.authenticatePerson(auth,appointment.getDoctor().getId());

        Patient patient = appointment.getPatient();

        if (!appointment.getState().equals(Appointment.AppointmentState.CONFIRMED)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, APPOINTMENT_NOT_CONFIRMED_ERROR_MESS);
        }

        JsonNullable<String> description = doneAppointmentDTO.getDescription();
        if (description.isPresent()) {
            appointment.setDescription(description.get());
        }
        JsonNullable<String> recommendations = doneAppointmentDTO.getRecommendations();
        if (recommendations.isPresent()) {
            appointment.setRecommendations(recommendations.get());
        }
        JsonNullable<List<AppointmentCreateReferralDTO>> referrals = doneAppointmentDTO.getReferrals();
        if (referrals.isPresent()) {
            referrals.get().forEach(referral ->
                referralService.addReferral(mapAppointmentCreateReferralDTOToReferral(referral, patient, appointment))
            );
        }
        JsonNullable<List<AppointmentCreatePrescriptionDTO>> prescriptions = doneAppointmentDTO.getPrescriptions();
        if (prescriptions.isPresent()) {
            prescriptions.get().forEach(prescription ->
                prescriptionService.addPrescription(mapAppointmentCreatePrescriptionDTOToPrescription(prescription, patient, appointment, appointment.getDoctor()))
            );
        }
        JsonNullable<List<AppointmentCreateAppointmentCheckUpDTO>> checkUps = doneAppointmentDTO.getCheckUps();
        if (checkUps.isPresent()) {
            checkUps.get().forEach(checkUp ->
                appointmentCheckUpService.saveAppointmentCheckUp(mapCreateAppointmentCheckUpDTOToAppointmentCheckUp(checkUp, appointment))
            );
        }
        appointment.setState(Appointment.AppointmentState.DONE);

        saveAppointment(appointment);
    }

    public void addCheckupResult(long appointmentId, long checkUpId, AddCheckUpResultDTO addCheckupResultDTO, Authentication auth){
        AppointmentCheckUp appointmentCheckUp = appointmentCheckUpService.getAppointmentCheckUp(appointmentId,checkUpId, auth, AppRole.DOCTOR);

        appointmentCheckUp.setResult(addCheckupResultDTO.getResult().get());
        appointmentCheckUp.setFile(addCheckupResultDTO.getFile().get());
        if (Objects.nonNull(addCheckupResultDTO.getDoctorsDescription().get())) {
            appointmentCheckUp.setDoctorsDescription(addCheckupResultDTO.getDoctorsDescription().get());
        }

        appointmentCheckUpService.saveAppointmentCheckUp(appointmentCheckUp);
    }

    public void deleteUnusedAppointments() {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByDateBeforeAndStateEquals(LocalDateTime.now(), Appointment.AppointmentState.AVAILABLE);
        appointmentRepository.deleteAll(appointments);
    }

    private Appointment mapCreateNewAppointmentToAppointment(CreateAppointmentDTO newAppointment){
        Appointment appointment = new Appointment();

        MedicalService medicalService = medicalServiceService.getServiceById(newAppointment.getMedicalServiceId());
        Doctor doctor = doctorService.getDoctorById(newAppointment.getDoctorId());
        appointment.setDoctor(doctor);
        appointment.setMedicalService(medicalService);
        appointment.setDate(newAppointment.getDate());
        appointment.setType(medicalService.isFacilityService() ? Appointment.AppointmentType.FACILITY : Appointment.AppointmentType.TELEPHONE);
        appointment.setState(Appointment.AppointmentState.AVAILABLE);

        return appointment;
    }

    private Referral mapAppointmentCreateReferralDTOToReferral(AppointmentCreateReferralDTO appointmentCreateReferralDTO,
                                                               Patient patient, Appointment appointment) {
        Referral referral = new Referral();
        referral.setExpiryDate(appointmentCreateReferralDTO.getExpiryDate());
        referral.setMedicalService(medicalServiceService.getServiceById(appointmentCreateReferralDTO.getMedicalServiceId()));
        referral.setPatient(patient);
        referral.setIssueAppointment(appointment);
        return referral;
    }

    private Prescription mapAppointmentCreatePrescriptionDTOToPrescription(AppointmentCreatePrescriptionDTO appointmentCreatePrescriptionDTO,
                                                                           Patient patient, Appointment appointment) {
        Prescription prescription = new Prescription();
        prescription.setCreationDate(LocalDate.now());
        prescription.setExpiryDate(appointmentCreatePrescriptionDTO.getExpiryDate());
        prescription.setAccessCode(appointmentCreatePrescriptionDTO.getAccessCode());
        prescription.setPatient(patient);
        prescription.setAppointment(appointment);
        appointmentCreatePrescriptionDTO.getMedications().forEach(createPrescriptionMedication -> {
            PrescriptionMedication prescriptionMedication = new PrescriptionMedication();
            Medication medication = medicationService.getMedicationById(createPrescriptionMedication.getMedicationId());
            prescriptionMedication.setMedication(medication);
            prescriptionMedication.setPrescription(prescription);
            prescriptionMedication.setDosing(createPrescriptionMedication.getDosing());
            prescriptionMedication.setNumberOfPackages(createPrescriptionMedication.getNumberOfPackages());
        });
        return prescription;
    }

    private AppointmentCheckUp mapCreateAppointmentCheckUpDTOToAppointmentCheckUp(AppointmentCreateAppointmentCheckUpDTO appointmentCreateAppointmentCheckUpDTO,
                                                                                  Appointment appointment) {
        AppointmentCheckUp appointmentCheckUp = new AppointmentCheckUp();
        CheckUp checkUp = checkUpService.getCheckUpById(appointmentCreateAppointmentCheckUpDTO.getCheckUpId());
        appointmentCheckUp.setAppointment(appointment);
        appointmentCheckUp.setCheckUp(checkUp);
        if (appointmentCreateAppointmentCheckUpDTO.getFile().isPresent()) {
            appointmentCheckUp.setFile(appointmentCreateAppointmentCheckUpDTO.getFile().get());
        }
        if (appointmentCreateAppointmentCheckUpDTO.getResult().isPresent()) {
            appointmentCheckUp.setResult(appointmentCreateAppointmentCheckUpDTO.getResult().get());
        }
        if (appointmentCreateAppointmentCheckUpDTO.getDescription().isPresent()) {
            appointmentCheckUp.setDoctorsDescription(appointmentCreateAppointmentCheckUpDTO.getDescription().get());
        }
        return appointmentCheckUp;
    }

}

