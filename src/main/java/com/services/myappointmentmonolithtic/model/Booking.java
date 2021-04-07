package com.services.myappointmentmonolithtic.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    protected Employee employee;
    @ManyToOne
    @JoinColumn(name = "client_id")
    protected Client client;
    protected LocalDateTime beginningTime;
    protected LocalDateTime finishingTime;
    @ManyToOne
    @JoinColumn(name = "provided_service_id")
    protected ProvidedService providedService;
    protected String bookingStatus;


}
