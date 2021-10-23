package com.pjatk.medicalcenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<Referral> referrals = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
