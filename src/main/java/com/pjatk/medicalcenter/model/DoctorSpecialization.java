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
        setDoctor(doctor);
        setSpecialization(specialization);
    }

    public void setDoctor(Doctor doctor) {
        doctor.addDoctorSpecialization(this);
        this.doctor = doctor;
    }

    public void setSpecialization(Specialization specialization) {
        specialization.addDoctorSpecialization(this);
        this.specialization = specialization;
    }

    public void addSchedules(List<Schedule> schedule){
        schedule.forEach(sch -> {
            sch.setDoctorSpecialization(this);
            this.schedules.add(sch);
        });
    }

    public void addSchedule(Schedule schedule){
        schedule.setDoctorSpecialization(this);
        this.schedules.add(schedule);
    }

    public void updateExistingOrAddNewSchedule(List<Schedule> schedule){
        schedule.forEach(sch -> {
            if(sch.getDoctorSpecialization() != null){

            }
            sch.setDoctorSpecialization(this);
            this.schedules.add(sch);
        });
    }
}
