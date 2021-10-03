package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Director;
import com.pjatk.medicalcenter.repository.DirectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }

    public Director getDirectorById(long id){
        return directorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Director does not exists"));
    }

    public Director addDirector(Director director){
        return directorRepository.save(director);
    }

    public Director updateDirector(Director director){
        if(directorRepository.findById(director.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Director does not exists")) != null)
            return directorRepository.save(director);

        return null;
    }

    public void deleteDirectorById(long id){
        directorRepository.delete(directorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Director does not exists")));
    }
}
