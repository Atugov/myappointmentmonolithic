package com.services.myappointmentmonolithtic.service;


import com.services.myappointmentmonolithtic.model.Booking;
import com.services.myappointmentmonolithtic.repository.JPABookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final JPABookingRepository bookingRepository;

    private static final Logger LOG = LoggerFactory.getLogger(BookingService.class);

    public BookingService(JPABookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void createBooking(Booking booking) {
        LOG.debug("createBooking(), saving booking");
        bookingRepository.save(booking);
    }

    public Booking getBookingById(String id) {
        return bookingRepository.getOne(id);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Booking booking) {
        LOG.debug("deleteBooking(), deleting booking");
        bookingRepository.delete(booking);
    }

}
