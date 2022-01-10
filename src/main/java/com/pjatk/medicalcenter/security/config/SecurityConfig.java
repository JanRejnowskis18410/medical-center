package com.pjatk.medicalcenter.security.config;

import com.pjatk.medicalcenter.security.filter.AuthenticationFilter;
import com.pjatk.medicalcenter.security.filter.AuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import static com.pjatk.medicalcenter.security.model.AppRole.DOCTOR;
import static com.pjatk.medicalcenter.security.model.AppRole.PATIENT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/login");

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/registration").permitAll();
        http.authorizeRequests().antMatchers(
                                "/appointments",
                                "/appointments/*/reserve",
                                "/appointments/*/confirm",
                                "/appointments/*/cancel",
                                "/doctors/specialization",
                                "/doctors/services",
                                "/doctors/*/schedule",
                                "/patients",
                                "/patients/*",
                                "/patients/*/referrals",
                                "/patients/*/prescriptions",
                                "/patients/*/files",
                                "/patients/*/files/*",
                                "/specializations")
                .hasAnyAuthority(PATIENT.getName());
        http.authorizeRequests().antMatchers(
                                "/appointments/*/testResult/*",
                                "/appointments/*/done",
                                "/doctors/*/todaysVisits",
                                "/doctors/*/testsWithoutResults",
                                "/medications",
                                "/patients/*/doneAppointments")
                .hasAnyAuthority(DOCTOR.getName());
        http.authorizeRequests().antMatchers(
                                "/appointments/diagnosticTests",
                                "/checkups",
                                "/patients/*/files",
                                "/patients/*/files/*",
                                "/patients/*/appointments",
                                "/patients/*/diagnosticTests",
                                "/users/*/changeCredentials",
                                "/medicalServices",
                                "/users")
                .hasAnyAuthority(DOCTOR.getName(), PATIENT.getName());

        http.authorizeRequests().anyRequest().denyAll();

        http.logout();
        http.addFilter(authenticationFilter);
        http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
