package com.services.myappointmentmonolithtic.model;


import com.services.myappointmentmonolithtic.constants.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    protected User user;
    protected LocalDate dateOfBirth;
    @OneToMany(mappedBy = "client")
    protected List<Booking> bookings;


}
