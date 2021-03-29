package com.services.myappointmentmonolithtic.model;


import com.services.myappointmentmonolithtic.constants.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    protected String name;
    protected String login;
    protected String password;
    protected String email;
    @Enumerated(EnumType.STRING)
    protected Role role;

}
