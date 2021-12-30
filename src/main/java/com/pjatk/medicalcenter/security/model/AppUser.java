package com.pjatk.medicalcenter.security.model;

import com.pjatk.medicalcenter.model.Person;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Column(nullable = false)
    private AppRole role;

    @OneToOne(mappedBy = "user")
//    @MapsId
    private Person person;

    public AppUser(Long id, String email, String password, AppRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.setUser(this);
    }
}
