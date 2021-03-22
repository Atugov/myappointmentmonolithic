package com.services.myappointmentmonolithtic.controller.rest;

import com.services.myappointmentmonolithtic.model.Client;
import com.services.myappointmentmonolithtic.service.AdminService;
import com.services.myappointmentmonolithtic.service.ClientService;
import com.services.myappointmentmonolithtic.service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/users")
public class UserRestController {
    private final ClientService clientService;
    private final AdminService adminService;
    private final EmployeeService employeeService;

    public UserRestController(ClientService clientService, AdminService adminService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.adminService = adminService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public List showAllUsers() {
        List allUsers = new ArrayList<>();
        allUsers.addAll(clientService.getAllClients());
        allUsers.addAll(adminService.getAllAdmins());
        allUsers.addAll(employeeService.getAllEmployee());
        return allUsers;
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        clientService.saveClient(client);
    }
}
