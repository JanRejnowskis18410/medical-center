package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.dto.CheckUpDTO;
import com.pjatk.medicalcenter.model.CheckUp;
import com.pjatk.medicalcenter.service.CheckUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/checkups")
public class CheckUpController {

    private final CheckUpService checkUpService;

    public CheckUpController(CheckUpService checkUpService) {
        this.checkUpService = checkUpService;
    }

    @GetMapping
    public ResponseEntity<List<CheckUpDTO>> getCheckUps() {
        List<CheckUp> checkUps = checkUpService.getCheckUps();
        return ResponseEntity.ok(checkUps.stream().map(CheckUpDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckUpDTO> getCheckUpById(@PathVariable long id) {
        return ResponseEntity.ok(new CheckUpDTO(checkUpService.getCheckUpById(id)));
    }

    @PostMapping
    public ResponseEntity<CheckUp> addCheckUp(@RequestBody CheckUpDTO checkUpDTO) {
        CheckUp createdCheckUp = checkUpService.addCheckUp(mapCheckUpDTOToCheckUp(checkUpDTO));

        return ResponseEntity.created(URI.create(String.format("/checkups/%d", createdCheckUp.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<CheckUp> updateCheckUp(@RequestBody CheckUpDTO checkUpDTO) {
        CheckUp updatedCheckUp = checkUpService.updateCheckUp(mapCheckUpDTOToCheckUp(checkUpDTO));
        return ResponseEntity.created(URI.create(String.format("/checkups/%d", updatedCheckUp.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheckUp(@PathVariable long id) {
        checkUpService.deleteCheckUpById(id);

        return ResponseEntity.ok("Success");
    }

    private CheckUp mapCheckUpDTOToCheckUp(CheckUpDTO checkUpDTO) {
        CheckUp checkUp = new CheckUp();
        checkUp.setId(checkUpDTO.getId());
        checkUp.setName(checkUp.getName());

        return checkUp;
    }
}
