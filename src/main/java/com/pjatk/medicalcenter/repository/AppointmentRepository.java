package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {

    Page<Appointment> findAppointmentsByPatientIdAndState(long patientId, Appointment.AppointmentState state, Pageable pageable);

    Page<Appointment> findAppointmentsByPatientId(long patientId, Pageable paging);
}
