package com.services.myappointmentmonolithtic.model;


import com.services.myappointmentmonolithtic.constants.Role;
import com.services.myappointmentmonolithtic.constants.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "employees")
public class Employee {
//    protected Map<Service, Double> priceListOfEmployee;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    protected String name;
    protected String login;
    protected String password;
    protected String email;
    protected Role role;

}