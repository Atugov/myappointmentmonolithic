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
    protected Long id;
    protected String name;
    protected String login;
    protected String password;
    protected String email;
    @Enumerated(EnumType.STRING)
    protected Role role;
    protected LocalDate dateOfBirth;


}
