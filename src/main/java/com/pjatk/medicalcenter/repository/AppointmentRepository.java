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

//    Page<Appointment> findAppointmentsByDoctorIdAndDateBetweenAndStateEquals(long doctorId, LocalDateTime localDateTime1, LocalDateTime localDateTime2, "CONFRMED", Pageable paging);

//    Page<Appointment> findAppointmentsByDoctorIdAndDateBetweenAndStateEquals(long doctorId, LocalDateTime localDateTime1, LocalDateTime localDateTime2, Appointment.AppointmentState appointmentState, Pageable pageable);

    Page<Appointment> findAppointmentsByDoctorIdAndDateBetweenAndStateIn(long doctorId, LocalDateTime localDateTime1, LocalDateTime localDateTime2, List<Appointment.AppointmentState> states, Pageable pageable);

    @Query(value = "SELECT * FROM appointment a " +
                   "WHERE DATE(a.date)=:date " +
                   "AND a.patient_id IS NOT NULL " +
                   "AND state='RESERVED'"
                   ,nativeQuery = true)
    List<Appointment> findAppointmentsByPatientIsNotNullAndDateAndState(@Param("date") LocalDate date);

    List<Appointment> findAppointmentsByDateBeforeAndStateEquals(LocalDateTime date, Appointment.AppointmentState appointmentState);
}