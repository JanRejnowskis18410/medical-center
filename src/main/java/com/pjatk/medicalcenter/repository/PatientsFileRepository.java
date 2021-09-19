package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.PatientsFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsFileRepository extends JpaRepository<PatientsFile, Long> {
}
