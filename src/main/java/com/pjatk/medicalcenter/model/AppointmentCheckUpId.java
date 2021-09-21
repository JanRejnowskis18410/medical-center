package com.pjatk.medicalcenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentCheckUpId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long checkUpId;
    private Long appointmentId;
}
