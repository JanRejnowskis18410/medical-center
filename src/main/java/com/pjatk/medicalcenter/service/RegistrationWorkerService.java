package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.RegistrationWorker;
import com.pjatk.medicalcenter.model.Patient;
import com.pjatk.medicalcenter.repository.RegistrationWorkerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.pjatk.medicalcenter.util.ErrorMessages.REGISTRATION_WORKER_NOT_FOUND_ERROR_MESS;

@Service
public class RegistrationWorkerService {

    private final RegistrationWorkerRepository registrationWorkerRepository;

    public RegistrationWorkerService(RegistrationWorkerRepository registrationWorkerRepository) {
        this.registrationWorkerRepository = registrationWorkerRepository;
    }

    public List<RegistrationWorker> getRegistrationWorkers(){
        return registrationWorkerRepository.findAll();
    }

    public RegistrationWorker getRegistrationWorkerById(long id){
        return registrationWorkerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,REGISTRATION_WORKER_NOT_FOUND_ERROR_MESS));
    }

    public RegistrationWorker addRegistrationWorker(RegistrationWorker registrationWorker){
        return registrationWorkerRepository.save(registrationWorker);
    }

    public RegistrationWorker updateRegistrationWorker(RegistrationWorker registrationWorker){
        if(registrationWorkerRepository.findById(registrationWorker.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, REGISTRATION_WORKER_NOT_FOUND_ERROR_MESS)) != null)
            return registrationWorkerRepository.save(registrationWorker);

        return null;
    }

    public void deleteRegistrationWorkerById(long id){
        registrationWorkerRepository.delete(registrationWorkerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,REGISTRATION_WORKER_NOT_FOUND_ERROR_MESS)));
    }
}
