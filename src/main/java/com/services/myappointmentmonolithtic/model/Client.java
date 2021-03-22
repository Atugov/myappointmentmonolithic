package com.services.myappointmentmonolithtic.model;


import com.services.myappointmentmonolithtic.constants.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
    @Column(name = "name")
    protected String name;
    @Column(name = "login")
    protected String login;
    @Column(name = "password")
    protected String password;
    @Column(name = "email")
    protected String email;
    @Column(name = "role")
    protected Role role;
    @Column(name = "date_of_birth")
    protected LocalDate dateOfBirth;


}
