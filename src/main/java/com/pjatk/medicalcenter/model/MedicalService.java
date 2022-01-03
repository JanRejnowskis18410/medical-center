package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "medicalService")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "medicalService")
    private List<Referral> referrals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id", nullable = true)
    @Setter(AccessLevel.NONE)
    private Specialization specialization;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private boolean facilityService;

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void setSpecialization(Specialization specialization) {
        specialization.addMedicalService(this);
        this.specialization = specialization;
    }

    public void addReferral(Referral referral) { referrals.add(referral); }
}
