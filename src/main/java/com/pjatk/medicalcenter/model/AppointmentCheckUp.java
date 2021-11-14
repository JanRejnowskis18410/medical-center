package com.pjatk.medicalcenter.model;

import javax.persistence.*;

@Entity
public class AppointmentCheckUp {

    @EmbeddedId
    private AppointmentCheckUpId appointmentCheckUpId = new AppointmentCheckUpId();

    @ManyToOne
    @MapsId("appointmentId")
    private Appointment appointment;

    @ManyToOne
    @MapsId("checkUpId")
    private CheckUp checkUp;

    @Column(nullable = false)
    private String result;

    @Column(nullable = true)
    private String description;

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    private byte[] file;
}
