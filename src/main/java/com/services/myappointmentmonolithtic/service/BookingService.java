package com.services.myappointmentmonolithtic.service;


import com.services.myappointmentmonolithtic.model.Booking;
import com.services.myappointmentmonolithtic.repository.JPABookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final JPABookingRepository bookingRepository;

    public BookingService(JPABookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findBookingByBookingStatus(status);
    }

    public List<Booking> getBookingByService(String service) {
        return bookingRepository.findBookingByBookingStatus(service);
    }

    public List<Booking> getAllBookingsByClientId(String id) {
        return bookingRepository.findAllByClientId(id);
    }
    public List<Booking> getAllBookingsByEmployeeId(String id) {
        return bookingRepository.findAllByEmployeeId(id);
    }
}
