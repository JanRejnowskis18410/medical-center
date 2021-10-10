package com.pjatk.medicalcenter.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FacilityAppointment extends Appointment{

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentCheckUp> appointmentCheckUps = new ArrayList<>();
}
