package com.services.myappointmentmonolithtic.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    protected User user;
    protected int salary;

}
