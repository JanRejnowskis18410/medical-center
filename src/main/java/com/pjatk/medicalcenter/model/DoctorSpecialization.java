package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Doctor_Specialization")
@IdClass(DoctorSpecializationId.class)
@Data
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

    @OneToMany(mappedBy = "doctorSpecialization")
    private List<Schedule> schedules = new ArrayList<>();

    public DoctorSpecialization(Doctor doctor, Specialization specialization){
        this.doctor=doctor;
        this.specialization=specialization;
    }

    public void setDoctor(Doctor doctor) {
        doctor.addDoctorSpecialization(this);
        this.doctor = doctor;
    }

    public void setSpecialization(Specialization specialization) {
        specialization.addDoctorSpecialization(this);
        this.specialization = specialization;
    }

    public void addSchedule(List<Schedule> schedule){
        schedule.forEach(sch -> {
            sch.setDoctorSpecialization(this);
            this.schedules.add(sch);
        });
    }
}
