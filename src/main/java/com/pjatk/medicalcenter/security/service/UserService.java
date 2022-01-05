package com.pjatk.medicalcenter.security.service;

import com.pjatk.medicalcenter.security.model.AppUser;
import com.pjatk.medicalcenter.security.model.dto.ChangeCredentialsDTO;
import com.pjatk.medicalcenter.security.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.pjatk.medicalcenter.util.ErrorMessages.USER_NOT_FOUND_ERROR_MESS;

@Service @Transactional @Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser addUser(AppUser user){
        userRepository.findAppUserByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalStateException("Email already taken"));
        log.info("Saving new user {} to the database", user.getEmail());
        return userRepository.save(user);
    }

    public AppUser getUserByEmail(String email) {
        log.info("Fetching user {}", email);
        return userRepository.findAppUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
    }

    public void updateUserCredentials(long id, ChangeCredentialsDTO changeCredentialsDTO, Authentication auth) {
        AppUser user = getUserByEmail((String) auth.getPrincipal());
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot authenticate.");
        else if(!Objects.equals(user.getId(), id)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");
        }
        AppUser appUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND_ERROR_MESS));

        appUser.setPassword(changeCredentialsDTO.getPassword());
        if(changeCredentialsDTO.getEmail().isPresent())
            appUser.setEmail(changeCredentialsDTO.getEmail().get());
        userRepository.save(appUser);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = userRepository.findAppUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));

        log.info("User found in the database: {}, {}", email, user.getRole());

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getId().toString()));
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
