package com.pjatk.medicalcenter.model;

import lombok.AccessLevel;
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
    @Setter(AccessLevel.NONE)
    private Appointment appointment;

    @ManyToOne
    @MapsId("checkUpId")
    @Setter(AccessLevel.NONE)
    private CheckUp checkUp;

    @Column(length = 1000)
    private String result;

    @Column(nullable = true, length = 500)
    private String doctorsDescription;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private Byte[] file;

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
        appointment.addAppointmentCheckUp(this);
    }

    public void setCheckUp(CheckUp checkUp) {
        this.checkUp = checkUp;
        checkUp.addAppointmentCheckUp(this);
    }
}
