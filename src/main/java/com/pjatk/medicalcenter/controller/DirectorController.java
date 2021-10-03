package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.model.Director;
import com.pjatk.medicalcenter.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<Director>> getDirectors(){
        return ResponseEntity.ok(directorService.getDirectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable long id){
        return ResponseEntity.ok(directorService.getDirectorById(id));
    }

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody Director Director){
        Director createdDirector = directorService.addDirector(Director);
        return ResponseEntity.created(URI.create(String.format("/directors/%d", createdDirector.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Director> updateDirector(@RequestBody Director Director){
        Director updatedDirector = directorService.updateDirector(Director);
        return ResponseEntity.created(URI.create(String.format("/directors/%d", updatedDirector.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable long id){
        directorService.deleteDirectorById(id);
        return ResponseEntity.ok("Success");
    }
}
