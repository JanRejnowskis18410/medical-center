package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentCheckUpRepository extends JpaRepository<AppointmentCheckUp, Long> {

    AppointmentCheckUp findAppointmentCheckUpByAppointmentIdAndCheckUpId(Long appointmentId, Long checkUpId);
    Page<AppointmentCheckUp> findAppointmentCheckUpByAppointmentPatientIdAndResultIsNotNull(Long patientId, Pageable pageable);
    @Query(value = "SELECT * FROM appointment_check_up ac " +
            "JOIN appointment a ON ac.appointment_id=a.id " +
            "WHERE result IS NULL AND state='DONE' AND a.doctor_id= :doctorId",
        nativeQuery = true)
    Page<AppointmentCheckUp> findDoctorAppointmentCheckUpsWithoutResult(long doctorId, Pageable pageable);
}
