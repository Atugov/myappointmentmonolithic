package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Admin;
import com.services.myappointmentmonolithtic.model.Client;
import com.services.myappointmentmonolithtic.model.Employee;
import com.services.myappointmentmonolithtic.model.User;
import com.services.myappointmentmonolithtic.repository.JPAUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommonUserService {
    private final JPAUserRepository userRepository;

    private final ClientService clientService;

    private final AdminService adminService;

    private final EmployeeService employeeService;

    public CommonUserService(JPAUserRepository userRepository, ClientService clientService, AdminService adminService, EmployeeService employeeService) {
        this.userRepository = userRepository;
        this.clientService = clientService;

        this.adminService = adminService;
        this.employeeService = employeeService;
    }


    public void saveUser(String name, String login, String password, String email, boolean isClient, boolean isAdmin, boolean isEmployee) {
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        Client client = null;
        Admin admin = null;
        Employee employee = null;
        if (isClient) {
            client = new Client();
            client.setDateOfBirth(LocalDate.now());
            client.setUser(user);
            client.setBookings(null);
            user.setClient(client);
        }
        if (isAdmin) {
            admin = new Admin();
            admin.setUser(user);
            admin.setSalary(0);
            user.setAdmin(admin);
        }
        if (isEmployee) {
            employee = new Employee();
            employee.setBookings(null);
            employee.setUser(user);
            employee.setProvidedServices(null);
            user.setEmployee(employee);
        }
        userRepository.save(user);
        if (client != null) {
            clientService.saveClient(client);
        }
        if (admin != null) {
            adminService.saveAdmin(admin);
        }
        if (employee != null) {
            employeeService.saveEmployee(employee);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.getOne(id);
    }

    public User getUserByName(String name){
        return userRepository.findUserByLogin(name);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
