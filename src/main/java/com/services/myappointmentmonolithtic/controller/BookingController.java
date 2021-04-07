package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.model.Booking;
import com.services.myappointmentmonolithtic.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("client{id}")
    public String getAllBookingsByClientId(Model model, @PathVariable String id){
        Booking booking1 = new Booking();
        booking1.setBookingStatus("active");

        bookingService.createBooking(booking1);

        return "bookings_by_clienid";
    }
    @GetMapping("employee{id}")
    public String getAllBookingsByEmployeeId(Model model, @PathVariable String id){
        Booking booking2 = new Booking();

        booking2.setBookingStatus("active");

        bookingService.createBooking(booking2);

        return "bookings_by_clienid";
    }
}
