package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.CheckUp;
import com.pjatk.medicalcenter.repository.CheckUpRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CheckUpService {

    private final CheckUpRepository checkUpRepository;

    public CheckUpService(CheckUpRepository checkUpRepository) {
        this.checkUpRepository = checkUpRepository;
    }

    public List<CheckUp> getCheckUps() {
        return checkUpRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public CheckUp getCheckUpById(long id) {
        return checkUpRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Check up does not exists"));
    }

    public CheckUp addCheckUp(CheckUp checkUp) {
        return checkUpRepository.save(checkUp);
    }

    public CheckUp updateCheckUp(CheckUp checkUp) {
        if (checkUpRepository.findById(checkUp.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Check up does not exists")) != null)
            return checkUpRepository.save(checkUp);

        return null;
    }

    public void deleteCheckUpById(long id) {
        CheckUp checkUp = checkUpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exists"));

        checkUpRepository.delete(checkUp);
    }

}
