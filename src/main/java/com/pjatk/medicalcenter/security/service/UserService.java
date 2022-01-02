package com.pjatk.medicalcenter.security.service;

import com.pjatk.medicalcenter.security.model.AppUser;
import com.pjatk.medicalcenter.security.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public AppUser getUserByEmail(String email){
        log.info("Fetching user {}", email);
        return userRepository.findAppUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
    }

    public List<AppUser> getUsers(){
        log.info("Fetching all users");
        return userRepository.findAll();
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
