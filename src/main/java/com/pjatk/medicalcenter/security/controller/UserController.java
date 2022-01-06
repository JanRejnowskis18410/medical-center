package com.pjatk.medicalcenter.security.controller;

import com.pjatk.medicalcenter.security.model.dto.ChangeCredentialsDTO;
import com.pjatk.medicalcenter.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PatchMapping("/{id}/changeCredentials")
    public ResponseEntity<Void> changePassword(@PathVariable long id,
                                               @RequestBody ChangeCredentialsDTO changeCredentialsDTO,
                                               Authentication auth){
        userService.updateUserCredentials(id,changeCredentialsDTO, auth);
        return ResponseEntity.noContent().build();
    }
}
