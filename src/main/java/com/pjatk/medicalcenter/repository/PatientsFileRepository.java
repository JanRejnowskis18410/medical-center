package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.PatientsFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsFileRepository extends JpaRepository<PatientsFile, Long> {
    public List<PatientsFile> getPatientsFileByPatientId(long id);
}
