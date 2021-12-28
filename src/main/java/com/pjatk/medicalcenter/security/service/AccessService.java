package com.pjatk.medicalcenter.security.service;

import com.pjatk.medicalcenter.security.model.AppUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class AccessService {

    private final UserService userService;

    public AccessService(UserService userService) {
        this.userService = userService;
    }

    public boolean isHimself(Authentication auth, Long personId){
        AppUser user = userService.getUserByEmail((String) auth.getPrincipal());
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot authenticate.");

        return Objects.equals(user.getId(), personId);
    }
}
