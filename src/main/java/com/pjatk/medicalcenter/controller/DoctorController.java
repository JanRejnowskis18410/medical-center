package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.Schedule;
import com.pjatk.medicalcenter.service.DoctorService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
@CrossOrigin
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}/todaysVisits")
    public ResponseEntity<Map<String, Object>> getDoctorsTodaysVisits(
            @PathVariable long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size,
            Authentication auth) {

        Pageable paging = PageRequest.of(page, size, Sort.by("date").ascending());
        Page<Appointment> todaysVisits = doctorService.getDoctorsTodaysVisit(id, paging, auth);

        Map<String,Object> response = new HashMap<>();
        response.put("appointments", todaysVisits.stream().map(AppointmentForDoctorDTO::new).collect(Collectors.toList()));
        response.put("currentPage", todaysVisits.getNumber());
        response.put("totalItems", todaysVisits.getTotalElements());
        response.put("totalPages", todaysVisits.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/testsWithoutResults")
    public ResponseEntity<Map<String, Object>> getDoctorsAppointmentWithCheckupsWithoutResult(
            @PathVariable long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size,
            Authentication auth) {

        Pageable paging = PageRequest.of(page, size, Sort.by("a.date").descending());
        Page<AppointmentCheckUp> appointmentCheckUps = doctorService.getDoctorsAppointmentsWithCheckupsWithoutResult(id, paging, auth);

        Map<String,Object> response = new HashMap<>();
        response.put("checkUps", appointmentCheckUps.stream().map(AppointmentCheckUpDTO::new).collect(Collectors.toList()));
        response.put("currentPage", appointmentCheckUps.getNumber());
        response.put("totalItems", appointmentCheckUps.getTotalElements());
        response.put("totalPages", appointmentCheckUps.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/specialization")
    public ResponseEntity<List<DoctorDTO>> getDoctorsBySpecialization(@RequestParam("id") Long id){
        return ResponseEntity.ok(doctorService.getDoctorsBySpecializationId(id)
                .stream().map(DoctorDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/services")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByMedicalServiceIdAndLanguages(@RequestParam("medicalServiceId") Long medicalServiceId, @RequestParam(value = "language") String language){
        return ResponseEntity.ok(doctorService.getDoctorsByMedicalServiceIdAndLanguage(medicalServiceId, Doctor.Language.valueOf(language))
                .stream().map(DoctorDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}/schedule")
    public ResponseEntity<DoctorWeeklyScheduleDTO> getDoctorWeeklySchedule(@PathVariable("id") Long id, @RequestParam("specializationId") Long specializationId){
        List<ScheduleDTO> scheduleDTOS = doctorService.getDoctorsSchedules(id,specializationId).stream().map(ScheduleDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(new DoctorWeeklyScheduleDTO(scheduleDTOS));
    }

}
