package com.pjatk.medicalcenter.model;

import javax.persistence.*;

@Entity
public class AppointmentCheckUp {

    @EmbeddedId
    private AppointmentCheckUpId id = new AppointmentCheckUpId();

    @ManyToOne
    @MapsId("appointmentId")
    private Appointment appointment;

    @ManyToOne
    @MapsId("checkUpId")
    private CheckUp checkUp;

    @Column
    private String result;

    @Column
    private String description;
}
