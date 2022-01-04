package com.pjatk.medicalcenter.security.controller;

import com.pjatk.medicalcenter.security.model.dto.ChangePasswordDTO;
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

    @PatchMapping("/{id}/changePassword")
    public ResponseEntity<Void> changePassword(@PathVariable long id,
                                               @RequestBody ChangePasswordDTO changePasswordDTO,
                                               Authentication auth){
        userService.updateUserPassword(id,changePasswordDTO, auth);
        return ResponseEntity.noContent().build();
    }
}
