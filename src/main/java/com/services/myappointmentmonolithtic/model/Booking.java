package com.services.myappointmentmonolithtic.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private Date beginningTime;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private Date finishingTime;
    @ManyToOne
    @JoinColumn(name = "provided_service_id")
    protected ProvidedService providedService;
    protected String bookingStatus;


}
