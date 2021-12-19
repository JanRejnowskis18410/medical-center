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

    @GetMapping
    public ResponseEntity<List<DoctorWithSpecializationDTO>> getDoctors(){
        return ResponseEntity.ok(doctorService.getDoctors().stream().map(DoctorWithSpecializationDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorWithSpecializationDTO> getDoctorById(@PathVariable long id){
        return ResponseEntity.ok(new DoctorWithSpecializationDTO(doctorService.getDoctorById(id)));
    }

    @GetMapping("/{id}/todaysVisits")
    public ResponseEntity<Map<String, Object>> getDoctorsTodaysVisits(
            @PathVariable long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("date").ascending());
        Page<Appointment> todaysVisits = doctorService.getDoctorsTodaysVisit(id, paging);

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
            @RequestParam(name = "size", defaultValue = "1") int size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("a.date").descending());
        Page<AppointmentCheckUp> appointmentCheckUps = doctorService.getDoctorsAppointmentsWithCheckupsWithoutResult(id, paging);

        Map<String,Object> response = new HashMap<>();
        response.put("appointments", appointmentCheckUps.stream().map(AppointmentCheckUpDTO::new).collect(Collectors.toList()));
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

    @PostMapping
    public ResponseEntity<DoctorWithSpecializationDTO> addDoctor(@Valid @RequestBody DoctorDTO doctorDTO){
        Doctor createdDoctor = doctorService.addDoctor(DTOsMapper.mapDoctorDTOtoDoctor(doctorDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", createdDoctor.getId()))).build();
    }

    @PostMapping("/{doctorId}/specializations")
    public ResponseEntity<DoctorWithSpecializationDTO> addDoctorSpecialization(@PathVariable long doctorId, @Valid @RequestBody SpecializationWithScheduleRequestDTO specializationWithScheduleRequestDTO){
        Doctor updatedDoctor = doctorService.addDoctorSpecializationWithSchedule(doctorId, specializationWithScheduleRequestDTO);
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @GetMapping("/{id}/specializations")
    public ResponseEntity<List<SpecializationWithSchedulesDTO>> getDoctorSpecializations(@PathVariable long id){
        return ResponseEntity.ok(doctorService.getDoctorSpecializations(id));
    }

    @PutMapping
    public ResponseEntity<DoctorWithSpecializationDTO> updateDoctor(@RequestBody DoctorWithSpecializationDTO doctorWithSpecializationDTO){
        Doctor updatedDoctor = doctorService.updateDoctor(DTOsMapper.mapDoctorWithSpecializationDTOtoDoctor(doctorWithSpecializationDTO));
        return ResponseEntity.created(URI.create(String.format("/doctors/%d", updatedDoctor.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctorById(id);
        return ResponseEntity.ok("Success");
    }

}
