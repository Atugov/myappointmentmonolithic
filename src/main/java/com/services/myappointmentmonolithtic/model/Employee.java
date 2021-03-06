package com.services.myappointmentmonolithtic.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    protected User user;
    @OneToMany(mappedBy = "employee")
    protected List<Booking> bookings;
    @OneToMany(mappedBy = "employee")
    protected List<ProvidedService> providedServices;
}