package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.RegistrationWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationWorkerRepository extends JpaRepository<RegistrationWorker, Long>
{
}
