package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.model.Employee;
import com.services.myappointmentmonolithtic.model.ProvidedService;
import com.services.myappointmentmonolithtic.model.User;
import com.services.myappointmentmonolithtic.service.CommonUserService;
import com.services.myappointmentmonolithtic.service.EmployeeService;
import com.services.myappointmentmonolithtic.service.ProvidedServiceServise;
import com.services.myappointmentmonolithtic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/providedservice")
public class ProvidedServiceController {
    ProvidedServiceServise providedServiceServise;
    EmployeeService employeeService;
    CommonUserService commonUserService;
    UserService userService;

    ProvidedServiceController(ProvidedServiceServise providedServiceServise, EmployeeService employeeService, CommonUserService commonUserService,
                              UserService userService) {
        this.providedServiceServise = providedServiceServise;
        this.employeeService = employeeService;
        this.commonUserService =commonUserService;
        this.userService = userService;
    }

    @GetMapping("/create-new-provided-service")
    public String showCreationPage(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "provided_service_creation";
    }

    @PostMapping("create-new-provided-service")
    public String newProvidedServicecreation(@RequestParam String name,
                                             @RequestParam double price,
                                             @RequestParam String description,
                                             @RequestParam String employeeName) {
        ProvidedService providedService = new ProvidedService();
        providedService.setName(name);
        providedService.setPrice(price);
        providedService.setDescription(description);
        User user = commonUserService.getUserByName(employeeName);
        providedService.setEmployee(employeeService.findEmployeeById(user.getId()));
        providedServiceServise.saveProvidedService(providedService);
        return "home";
    }
    @GetMapping("/all-provided-service")
    public String showAllProvidedServices(Model model) {
        List<ProvidedService> services = providedServiceServise.getAllProvidedServices();
        model.addAttribute("services", services);
        return "provided_service_list";
    }
    @GetMapping("/all-provided-service-by-employee")
    public String showAllProvidedServicesByEmployeeId(Model model) {
        List<ProvidedService> services = providedServiceServise.getAllProvidedServicesByEmployeeId(userService.getCurrentUser().getId());
        model.addAttribute("services", services);
        return "provided_service_list";
    }
}
