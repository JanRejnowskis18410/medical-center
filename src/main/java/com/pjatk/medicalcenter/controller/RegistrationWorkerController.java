package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.model.RegistrationWorker;
import com.pjatk.medicalcenter.service.RegistrationWorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/registrationWorkers")
public class RegistrationWorkerController {

    private final RegistrationWorkerService registrationWorkerService;

    public RegistrationWorkerController(RegistrationWorkerService registrationWorkerService) {
        this.registrationWorkerService = registrationWorkerService;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationWorker>> getRegistrationWorkers(){
        return ResponseEntity.ok(registrationWorkerService.getRegistrationWorkers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationWorker> getRegistrationWorkerById(@PathVariable long id){
        return ResponseEntity.ok(registrationWorkerService.getRegistrationWorkerById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationWorker> addRegistrationWorker(@RequestBody RegistrationWorker RegistrationWorker){
        RegistrationWorker createdRegistrationWorker = registrationWorkerService.addRegistrationWorker(RegistrationWorker);
        return ResponseEntity.created(URI.create(String.format("/registrationWorkers/%d", createdRegistrationWorker.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<RegistrationWorker> updateRegistrationWorker(@RequestBody RegistrationWorker RegistrationWorker){
        RegistrationWorker updatedRegistrationWorker = registrationWorkerService.updateRegistrationWorker(RegistrationWorker);
        return ResponseEntity.created(URI.create(String.format("/registrationWorkers/%d", updatedRegistrationWorker.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegistrationWorker(@PathVariable long id){
        registrationWorkerService.deleteRegistrationWorkerById(id);
        return ResponseEntity.ok("Success");
    }
}
