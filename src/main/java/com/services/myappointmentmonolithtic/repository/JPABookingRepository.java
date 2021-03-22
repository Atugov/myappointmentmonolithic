package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.constants.Service;
import com.services.myappointmentmonolithtic.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPABookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findBookingByBookingStatus(String status);
    List<Booking> findBookingByService(Service service);
    List<Booking> findAllByClientId(String id);
    List<Booking> findAllByEmployeeId(String id);
}
