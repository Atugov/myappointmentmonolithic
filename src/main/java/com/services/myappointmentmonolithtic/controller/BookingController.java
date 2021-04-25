package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.constants.BookingStatus;
import com.services.myappointmentmonolithtic.model.Booking;
import com.services.myappointmentmonolithtic.model.User;
import com.services.myappointmentmonolithtic.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("booking")
public class BookingController {

    private BookingService bookingService;
    private CommonUserService commonUserService;
    private EmployeeService employeeService;
    private UserService userService;
    private ClientService clientService;
    private ProvidedServiceServise providedServiceServise;

    public BookingController(BookingService bookingService, CommonUserService commonUserService,
                             EmployeeService employeeService, UserService userService, ClientService clientService,
                             ProvidedServiceServise providedServiceServise) {
        this.bookingService = bookingService;
        this.commonUserService = commonUserService;
        this.employeeService = employeeService;
        this.userService = userService;
        this.clientService = clientService;
        this.providedServiceServise = providedServiceServise;
    }
    @GetMapping()
        public String toStartCreatingNewBooking(Model model) {
        model.addAttribute("services", providedServiceServise.getAllProvidedServices());
        return "new-booking";
    }

    @PostMapping("/new")
    public String createNewBooking(@RequestParam String providedServiceId, Model model) {
        model.addAttribute("providedService", providedServiceServise.getProvidedServiceById(providedServiceId));
        model.addAttribute("booking", new Booking());
        String template = null;
        if(userService.getCurrentUser() == null){
            template = "creating-booking-anonymus";
        }else{
            template = "creating-booking";
        }
        return template;
    }

    @PostMapping("/new-booking")
    public String fillNewBooking(Booking booking, @RequestParam String employeeId,
                                 @RequestParam String providedServiceId) {
        booking.setEmployee(employeeService.findEmployeeById(employeeId));
        booking.setProvidedService(providedServiceServise.getProvidedServiceById(providedServiceId));
        booking.setClient(clientService.getClientById(userService.getCurrentUser().getId()));
        booking.setBookingStatus(BookingStatus.PLANNED.toString());
        bookingService.createBooking(booking);
        String template = null;
        if(userService.getCurrentUser() == null){
            template = "home";
        }else{
            template = "redirect:/account";
        }
        return template;
    }

    @GetMapping("/all")
    public String getAllBookings(Model model) {
        User currentUser = userService.getCurrentUser();
        List<Booking> bookingsForCurrentUser = bookingService.getAllBookingsByClientId(currentUser.getId());
        model.addAttribute("bookings", bookingsForCurrentUser);
        return "all-bookings";
    }
}
