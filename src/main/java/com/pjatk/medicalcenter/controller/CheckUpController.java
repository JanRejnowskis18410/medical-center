package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.model.CheckUp;
import com.pjatk.medicalcenter.service.CheckUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/checkups")
public class CheckUpController {

    private final CheckUpService checkUpService;

    public CheckUpController(CheckUpService checkUpService) {
        this.checkUpService = checkUpService;
    }

    @GetMapping
    public ResponseEntity<List<CheckUp>> getCheckUps() {
        return ResponseEntity.ok(checkUpService.getCheckUps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckUp> getCheckUpById(@PathVariable long id) {
        return ResponseEntity.ok(checkUpService.getCheckUpById(id));
    }

    @PostMapping
    public ResponseEntity<CheckUp> addCheckUp(@RequestBody CheckUp checkUp) {
        CheckUp createdCheckUp = checkUpService.addCheckUp(checkUp);

        return ResponseEntity.created(URI.create(String.format("/checkups/%d", createdCheckUp.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<CheckUp> updateCheckUp(@RequestBody CheckUp checkUp) {
        CheckUp updatedCheckUp = checkUpService.updateCheckUp(checkUp);

        return ResponseEntity.created(URI.create(String.format("/checkups/%d", updatedCheckUp.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheckUp(@PathVariable long id) {
        checkUpService.deleteCheckUpById(id);

        return ResponseEntity.ok("Success");
    }

}
