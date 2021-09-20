package com.pjatk.medicalcenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentCheckUpId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long checkUpId;
    private Long appointmentId;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((checkUpId == null) ? 0 : checkUpId.hashCode());
        result = prime * result
                + ((appointmentId == null) ? 0 : appointmentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AppointmentCheckUpId other = (AppointmentCheckUpId) obj;
        return Objects.equals(getCheckUpId(), other.getCheckUpId()) && Objects.equals(getAppointmentId(), other.getAppointmentId());
    }
}
