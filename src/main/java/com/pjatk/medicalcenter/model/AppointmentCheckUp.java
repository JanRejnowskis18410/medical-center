package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AppointmentCheckUp {

    @EmbeddedId
    private AppointmentCheckUpId appointmentCheckUpId = new AppointmentCheckUpId();

    @ManyToOne
    @MapsId("appointmentId")
    private Appointment appointment;

    @ManyToOne
    @MapsId("checkUpId")
    private CheckUp checkUp;

    @Column(length = 1000)
    private String result;

    @Column(nullable = true)
    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] file;
}
