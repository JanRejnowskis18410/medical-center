package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentCheckUpRepository extends JpaRepository<AppointmentCheckUp, Long> {

    AppointmentCheckUp findAppointmentCheckUpByAppointmentIdAndCheckUpId(Long appointmentId, Long checkUpId);
    Page<AppointmentCheckUp> findAppointmentCheckUpByAppointmentPatientIdAndResultIsNotNull(Long patientId, Pageable pageable);
}
