package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {

    Page<Appointment> findAppointmentsByPatientIdAndState(long patientId, Appointment.AppointmentState state, Pageable pageable);

    Page<Appointment> findAppointmentsByPatientId(long patientId, Pageable paging);

    Page<Appointment> findAppointmentsByDoctorIdAndDateBetween(long doctorId, LocalDateTime localDateTime1, LocalDateTime localDateTime2, Pageable paging);

    @Query(value = "SELECT * FROM appointment a " +
                   "WHERE DATE(a.date)=:date " +
                   "AND a.patient_id IS NOT NULL " +
                   "AND state='RESERVED'"
                   ,nativeQuery = true)
    List<Appointment> findAppointmentsByPatientIsNotNullAndDateAndState(@Param("date") LocalDate date);

    @Query(value = "SELECT * FROM appointment a " +
            "WHERE DATE(a.date)=:date " +
            "AND a.patient_id IS NOT NULL " +
            "AND state='RESERVED'"
            ,nativeQuery = true)
    List<Appointment> findReservedAppointmentsVisitIn2days(@Param("date") LocalDate date);

    @Query(value = "SELECT * FROM appointment a " +
            "WHERE DATE(a.date)=:date " +
            "AND a.patient_id IS NOT NULL " +
            "AND state='CONFIRMED'"
            ,nativeQuery = true)
    List<Appointment> findConfirmedAppointmentsVisitIn2days(@Param("date") LocalDate date);

    @Query(value = "SELECT * FROM appointment a " +
            "WHERE DATE(a.date)=:date " +
            "AND a.patient_id IS NOT NULL " +
            "AND (state='CONFIRMED' OR state='RESERVED')"
            ,nativeQuery = true)
    List<Appointment> findConfirmedAndReservedAppointmentsVisitIn2days(@Param("date") LocalDate date);
}