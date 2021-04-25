package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.constants.Role;
import com.services.myappointmentmonolithtic.model.User;
import com.services.myappointmentmonolithtic.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final CommonUserService commonUserService;

    private final UserService userService;

    private final ClientService clientService;

    private final EmployeeService employeeService;

    private final AdminService adminService;


    public UserController(CommonUserService commonUserService, UserService userService, ClientService clientService, EmployeeService employeeService, AdminService adminService) {
        this.commonUserService = commonUserService;
        this.userService = userService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.adminService = adminService;
    }


    @PostMapping("/registration")
    public String registerNewUser(@RequestParam(required = false) boolean isClient,
                                  @RequestParam(required = false) boolean isAdmin,
                                  @RequestParam(required = false) boolean isEmployee,
                                  Model model) {
        model.addAttribute("isClient", isClient);
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isEmployee", isEmployee);
        return "registration";
    }
    @GetMapping("/choosingrole")
    public String beforeRegisterNewUser() {
        return "choosingrole";
    }

    @PostMapping("/saveuser")
    public String saveUser(@RequestParam String name,
                           @RequestParam String login,
                           @RequestParam String password,
                           @RequestParam String email,
                           @RequestParam(required = false) boolean isClient,
                           @RequestParam(required = false) boolean isAdmin,
                           @RequestParam(required = false) boolean isEmployee) {
        commonUserService.saveUser(name,login, password, email, isClient, isAdmin, isEmployee);
        return "redirect:/";

    }

    @GetMapping("allusers")
    public String showAllUsers(Model model) {
        List<User> users = commonUserService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("allclients")
    public String showAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("allemployees")
    public String showAllEmoloyees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "employees";
    }
    @GetMapping("alladmins")
    public String showAllAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admins";
    }

    @GetMapping("/user")
    public String getCurrentUser(Model model){
        User currentUser =  userService.getCurrentUser();
        String template = null;
        if (currentUser.getAdmin() != null) {
            template = "admins";
            model.addAttribute("admins",adminService.findAdminById(currentUser.getId()));
        }
        if (currentUser.getEmployee() != null) {
            template = "employees";
            model.addAttribute("employees",employeeService.findEmployeeById(currentUser.getId()));
        }
        if (currentUser.getClient() != null) {
            template = "clients";
            model.addAttribute("clients",clientService.getClientById(currentUser.getId()));
        }
        return template;
    }
//
//    @GetMapping("admin{id}")
//    public String getAdminById(Model model, @PathVariable String id) {
//        model.addAttribute("admins_or_employees", adminService.findAdminById(id));
//        return "admins_or_employees";
//    }
//    @GetMapping("employee{id}")
//    public String getEmployeeById(Model model, @PathVariable String id) {
//        model.addAttribute("admins_or_employees", employeeService.findEmployeeById(id));
//        return "admins_or_employees";
//    }
//
//    @GetMapping("/clients")
//    public String getAllClients(Model model){
//        model.addAttribute("clients", clientService.getAllClients());
//        return "clients";
//    }
//
//    @GetMapping("/employees")
//    public String getAllEmployees(Model model){
//        model.addAttribute("admins_or_employees", employeeService.getAllEmployee());
//        return "admins_or_employees";
//    }
//
//    @GetMapping("/admins")
//    public String getAllAdmins(Model model){
//        model.addAttribute("admins_or_employees", adminService.getAllAdmins());
//        return "admins_or_employees"
//    @GetMapping("admin/{name}")
//    public String getAdminByName(Model model, @PathVariable String name) throws NoSuchAdminException {
//        model.addAttribute("admins_or_employees", adminService.findAdminByName(name));
//        return "admins_or_employees";
//    }
}
