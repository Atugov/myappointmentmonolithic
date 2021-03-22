package com.services.myappointmentmonolithtic.controller.rest;

import com.services.myappointmentmonolithtic.model.Booking;
import com.services.myappointmentmonolithtic.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/booking")
public class BookingRestController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("client{id}")
    public Booking getAllBookingsByClientId(@PathVariable String id){
        return null;
    }


}
