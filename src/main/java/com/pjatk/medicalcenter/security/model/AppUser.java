package com.pjatk.medicalcenter.security.model;

import com.pjatk.medicalcenter.model.Person;
import com.pjatk.medicalcenter.security.encoder.AttributeEncryptor;
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

    @Column(nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppRole role;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @MapsId
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        person.setUser(this);
    }
}
