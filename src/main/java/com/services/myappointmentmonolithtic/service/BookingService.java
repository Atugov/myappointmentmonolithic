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

    public void deleteBooking(Booking booking) {
        LOG.debug("deleteBooking(), deleting booking");
        bookingRepository.delete(booking);
    }

    public List<Booking> getBookingsByStatus(String status) {
        LOG.debug("getBookingsByStatus(), getting booking by status");
        return bookingRepository.findBookingByBookingStatus(status);
    }

    public List<Booking> getBookingByService(String service) {
        LOG.debug("getBookingByService(), getting booking by service");
        return bookingRepository.findBookingByBookingStatus(service);
    }

    public List<Booking> getAllBookingsByClientId(String id) {
        LOG.debug("getAllBookingsByClientId(), getting all bookings by client id");
        return bookingRepository.findAllByClientId(id);
    }
    public List<Booking> getAllBookingsByEmployeeId(String id) {
        LOG.debug("getAllBookingsByEmployeeId(), getting all bookings by employee id");
        return bookingRepository.findAllByEmployeeId(id);
    }
}
