package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.util.DTOsMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientsDoneVisitDTO {

    private Long id;
    private String serviceName;
    private DoctorDTO doctor;
    private LocalDateTime date;
    private String recommendations;
    private Appointment.AppointmentType type;
    private Appointment.AppointmentState state;
    private List<ReferralDTO> issuedReferrals;
    private List<PrescriptionDTO> prescriptions;
    private List<AppointmentCheckUpDTO> diagnosticTests;

    public PatientsDoneVisitDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.serviceName = appointment.getMedicalService().getName();
        this.doctor = new DoctorDTO(appointment.getDoctor());
        this.date = appointment.getDate();
        this.recommendations = appointment.getRecommendations();
        this.type = appointment.getType();
        this.state = appointment.getState();
        this.issuedReferrals = appointment.getIssuedReferrals().stream()
                                .map(ReferralDTO::new)
                                .collect(Collectors.toList());
        this.prescriptions = appointment.getPrescriptions().stream()
                                .map(PrescriptionDTO::new)
                                .collect(Collectors.toList());
        this.diagnosticTests = appointment.getAppointmentCheckUps().stream()
                                .map(DTOsMapper::mapAppointmentTestDTOToAppointmentTest)
                                .collect(Collectors.toList());
    }

}
