package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT * FROM doctor d " +
            "JOIN person p ON d.id=p.id " +
            "JOIN language l ON d.id=l.doctor_id " +
            "JOIN doctor_specialization ds ON d.id=ds.doctor_id " +
            "JOIN specialization s ON ds.specialization_id=s.id " +
            "JOIN medical_service ms on s.id=ms.specialization_id " +
            "WHERE ms.id= :serviceId AND l.doctor_language=:language " +
            "ORDER BY p.last_name",
            nativeQuery = true)
    List<Doctor> findDoctorsByMedicalServiceIdAndLanguage(@Param("serviceId") long serviceId, @Param("language") String language);

    @Query(value = "SELECT * FROM doctor d " +
            "JOIN person p ON d.id=p.id " +
            "JOIN doctor_specialization ds ON d.id=ds.doctor_id " +
            "JOIN specialization s ON ds.specialization_id=s.id " +
            "WHERE s.id= :specializationId " +
            "ORDER BY p.last_name",
            nativeQuery = true)
    List<Doctor> findDoctorsBySpecializationId(@Param("specializationId") long specializationId);

    Doctor findByPesel(String pesel);
}
