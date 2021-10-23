package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByTypeAndPatientIsNullAndDateAfter(Appointment.AppointmentType appointmentType,LocalDateTime localDateTime);
}
