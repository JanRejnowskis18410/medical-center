package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(mappedBy = "checkUp")
    private List<AppointmentCheckUp> appointmentCheckUps = new ArrayList<>();

    public void addAppointmentCheckUp(AppointmentCheckUp appointmentCheckUp) {
        appointmentCheckUps.add(appointmentCheckUp);
    }
}
