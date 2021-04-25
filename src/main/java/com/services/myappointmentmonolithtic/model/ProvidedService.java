package com.services.myappointmentmonolithtic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "provided_service")
public class ProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    protected String name;
    protected double price;
    protected String description;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    protected Employee employee;
    @OneToMany(mappedBy = "providedService")
    protected List<Booking> bookings;
}
