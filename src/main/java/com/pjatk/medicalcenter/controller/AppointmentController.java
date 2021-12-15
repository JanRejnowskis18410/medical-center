package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.*;
import com.pjatk.medicalcenter.service.*;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final ReferralService referralService;
    private final AppointmentCheckUpService appointmentCheckUpService;
    private final MedicalServiceService medicalServiceService;
    private final PrescriptionService prescriptionService;
    private final MedicationService medicationService;
    private final CheckUpService checkUpService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService,
                                 ReferralService referralService, AppointmentCheckUpService appointmentCheckUpService,
                                 MedicalServiceService medicalServiceService, PrescriptionService prescriptionService,
                                 MedicationService medicationService, CheckUpService checkUpService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.referralService = referralService;
        this.appointmentCheckUpService = appointmentCheckUpService;
        this.medicalServiceService = medicalServiceService;
        this.prescriptionService = prescriptionService;
        this.medicationService = medicationService;
        this.checkUpService = checkUpService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailableAppointmentDTO>> getAppointments() {
        List<Appointment> availableAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAvailableAppointments(
                @RequestParam(name = "medicalServiceId", required = true) Long medicalServiceId,
                @RequestParam(name = "doctorId", required = false) Long doctorId,
                @RequestParam(name = "dateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                @RequestParam(name = "dateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo,
                @RequestParam(name = "language", required = true) Doctor.Language language,
                @RequestParam(name = "page", defaultValue = "0") int page,
                @RequestParam(name = "size", defaultValue = "1") int size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("date").ascending());
        AvailableAppointmentsRequestDTO aarDTO = new AvailableAppointmentsRequestDTO(medicalServiceId,doctorId,dateFrom,dateTo,language);
        Page<Appointment> availableAppointments = appointmentService.getAvailableAppointments(aarDTO, paging);

        Map<String,Object> response = new HashMap<>();
        response.put("appointments", availableAppointments.stream().map(AvailableAppointmentDTO::new).collect(Collectors.toList()));
        response.put("currentPage", availableAppointments.getNumber());
        response.put("totalItems", availableAppointments.getTotalElements());
        response.put("totalPages", availableAppointments.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientsDoneVisitDTO> getAppointmentById(@PathVariable long id){
        return ResponseEntity.ok(new PatientsDoneVisitDTO(appointmentService.getAppointmentById(id)));
    }

    @GetMapping("/diagnosticTests")
    public ResponseEntity<AppointmentCheckUpDTO> getAppointmentCheckUpById(@RequestParam("appointmentId") long appointmentId, @RequestParam("checkUpId") long checkUpId){
        return ResponseEntity.ok(new AppointmentCheckUpDTO(appointmentCheckUpService.getAppointmentCheckUp(appointmentId,checkUpId)));
    }

    @PostMapping
    public ResponseEntity<AvailableAppointmentDTO> addAppointment(@Valid @RequestBody CreateAppointmentDTO createAppointmentDTO) {
        Appointment createdAppointment = appointmentService.saveAppointment(createAppointmentDTO);
        return ResponseEntity.created(URI.create(String.format("/appointments/%d", createdAppointment.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id){
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok("Success");
    }

    //TODO: check if validation works
    @PatchMapping("{id}/reserve")
    public ResponseEntity<Void> reserveAppointment(@PathVariable("id") long id,
                                                   @Valid @RequestBody ConfirmAppointmentDTO confirmAppointmentDTO) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        JsonNullable<Long> patientId = confirmAppointmentDTO.getPatientId();
        if (patientId.isPresent()) {
            Patient patient = patientService.getPatientById(patientId.get());
            appointment.setPatient(patient);
        }

        JsonNullable<Long> referralId = confirmAppointmentDTO.getReferralId();
        if (referralId.isPresent()) {
            Referral referral = referralService.getReferralById(referralId.get());
            appointment.setReferral(referral);
        }

        LocalDate appointmentDate = appointment.getDate().toLocalDate();
        if (LocalDate.now().isEqual(appointmentDate)) {
            appointment.setState(Appointment.AppointmentState.CONFIRMED);
        } else {
            appointment.setState(Appointment.AppointmentState.RESERVED);
        }

        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/confirm")
    public ResponseEntity<Void> confirmAppointment(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        appointment.setState(Appointment.AppointmentState.CONFIRMED);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        if(appointment.getState().equals(Appointment.AppointmentState.CONFIRMED)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment confirmed- cannot cancel");
        }
        if (appointment.getReferral() != null) {
            appointment.setReferral(null);
        }
        if (appointment.getPatient() != null) {
            appointment.setPatient(null);
        }

        appointment.setState(Appointment.AppointmentState.AVAILABLE);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{appointmentId}/testResult/{checkUpId}")
    public ResponseEntity<Void> addCheckupResult(@PathVariable("appointmentId") long appointmentId,
                                                 @PathVariable("appointmentId") long checkUpId,
                                                 @Valid @RequestBody PatchAppointmentCheckUpDTO patchAppointmentCheckUpDTO) {

        AppointmentCheckUp appointmentCheckUp = appointmentCheckUpService.getAppointmentCheckUp(appointmentId,checkUpId);

        appointmentCheckUp.setResult(patchAppointmentCheckUpDTO.getResult().get());
        appointmentCheckUp.setFile(patchAppointmentCheckUpDTO.getFile().get());
        if (Objects.nonNull(patchAppointmentCheckUpDTO.getDoctorsDescription().get())) {
            appointmentCheckUp.setDoctorsDescription(patchAppointmentCheckUpDTO.getDoctorsDescription().get());
        }

        appointmentCheckUpService.saveAppointmentCheckUp(appointmentCheckUp);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/done")
    public ResponseEntity<Void> doneAppointment(@PathVariable("id") long id,
                                                @Valid @RequestBody DoneAppointmentDTO doneAppointmentDTO) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        Patient patient = appointment.getPatient();

        if (!appointment.getState().equals(Appointment.AppointmentState.CONFIRMED)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Appointment was not confirmed");
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
            referrals.get().forEach(referral -> {
                referralService.addReferral(mapAppointmentCreateReferralDTOToReferral(referral, patient, appointment));
            });
        }
        JsonNullable<List<AppointmentCreatePrescriptionDTO>> prescriptions = doneAppointmentDTO.getPrescriptions();
        if (prescriptions.isPresent()) {
            prescriptions.get().forEach(prescription -> {
                prescriptionService.addPrescription(mapAppointmentCreatePrescriptionDTOToPrescription(prescription, patient, appointment, appointment.getDoctor()));
            });
        }
        JsonNullable<List<AppointmentCreateAppointmentCheckUpDTO>> checkUps = doneAppointmentDTO.getCheckUps();
        if (checkUps.isPresent()) {
            checkUps.get().forEach(checkUp -> {
                appointmentCheckUpService.saveAppointmentCheckUp(mapCreateAppointmentCheckUpDTOToAppointmentCheckUp(checkUp, appointment));
            });
        }
        appointment.setState(Appointment.AppointmentState.DONE);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.noContent().build();
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
                                                                           Patient patient, Appointment appointment, Doctor doctor) {
        Prescription prescription = new Prescription();
        prescription.setCreationDate(LocalDate.now());
        prescription.setExpiryDate(appointmentCreatePrescriptionDTO.getExpiryDate());
        prescription.setAccessCode(appointmentCreatePrescriptionDTO.getAccessCode());
        prescription.setDoctor(doctor);
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
