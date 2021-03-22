package com.services.myappointmentmonolithtic.model;



import com.services.myappointmentmonolithtic.constants.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "bookings")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    protected String employeeId;
    protected String clientId;
    protected LocalDateTime beginningTime;
    protected LocalDateTime finishingTime;
    protected Service service;
    protected String bookingStatus;


}
