package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Doctor_Specialization")
@IdClass(DoctorSpecializationId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSpecialization {

    @Id
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @NonNull
    private Doctor doctor;

    @Id
    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    @NonNull
    private Specialization specialization;

    @Embedded
    @NonNull
    private Schedule schedule;
}
