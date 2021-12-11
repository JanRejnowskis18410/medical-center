package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalService, Long> {
    List<MedicalService> findMedicalServicesByFacilityServiceIsFalseOrderByNameAsc();
    List<MedicalService> findMedicalServicesByFacilityServiceIsTrueOrderByNameAsc();
}
