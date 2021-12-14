package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentCheckUpRepository extends JpaRepository<AppointmentCheckUp, Long> {

    public AppointmentCheckUp findAppointmentCheckUpByAppointmentIdAndCheckUpId(Long appointmentId, Long checkUpId);
}
