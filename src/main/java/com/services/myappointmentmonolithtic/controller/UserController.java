package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.constants.Role;
import com.services.myappointmentmonolithtic.model.Admin;
import com.services.myappointmentmonolithtic.model.Client;
import com.services.myappointmentmonolithtic.model.Employee;
import com.services.myappointmentmonolithtic.service.AdminService;
import com.services.myappointmentmonolithtic.service.ClientService;
import com.services.myappointmentmonolithtic.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private final ClientService clientService;
    private final AdminService adminService;
    private final EmployeeService employeeService;

    public UserController(ClientService clientService, AdminService adminService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.adminService = adminService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        List allUsers = new ArrayList<>();
        allUsers.addAll(clientService.getAllClients());
        allUsers.addAll(adminService.getAllAdmins());
        allUsers.addAll(employeeService.getAllEmployee());
        model.addAttribute("all_users", allUsers);
        return "users";
    }

    @GetMapping("{id}")
    public String getClientById(Model model, @PathVariable Long id) {
        model.addAttribute("client", clientService.getClientById(id));
        return "single_client";
    }

    @GetMapping("/clients")
    public String getAllClients(Model model){
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("admins_or_employees", employeeService.getAllEmployee());
        return "admins_or_employees";
    }

    @GetMapping("/admins")
    public String getAllAdmins(Model model){
        model.addAttribute("admins_or_employees", adminService.getAllAdmins());
        return "admins_or_employees";
    }
}
