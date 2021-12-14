package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.*;
import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.Schedule;
import com.pjatk.medicalcenter.service.DoctorService;
import com.pjatk.medicalcenter.util.DTOsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
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
    public ResponseEntity<List<AppointmentForDoctorDTO>> getDoctorsTodaysVisits(@PathVariable long id){
        return ResponseEntity.ok(doctorService
                                .getDoctorsTodaysVisit(id)
                                .stream()
                                .map(AppointmentForDoctorDTO::new)
                                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}/testsWithoutResults")
    public ResponseEntity<List<AppointmentCheckUpDTO>> getDoctorsAppointmentWithCheckupsWithoutResult(@PathVariable long id){
        return ResponseEntity.ok(doctorService
                                .getDoctorsAppointmentWithCheckupsWithoutResult(id)
                                .stream()
                                .map(AppointmentCheckUpDTO::new)
                                .collect(Collectors.toList()));
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
