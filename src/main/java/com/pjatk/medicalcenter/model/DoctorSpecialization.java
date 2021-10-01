package com.pjatk.medicalcenter.model;

import javax.persistence.*;

@Entity
@Table(name="Doctor_Specialization")
@IdClass(DoctorSpecializationId.class)
public class DoctorSpecialization {

    @Id
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @Id
    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private Specialization specialization;

    @Embedded
    private Schedule schedule;
}
