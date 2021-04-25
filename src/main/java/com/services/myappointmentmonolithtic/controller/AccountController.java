package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.constants.Role;
import com.services.myappointmentmonolithtic.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public String getAccount(HttpServletRequest request, Authentication authentication, Model model) {
        String account = null;
        userService.setCurrentUser(authentication.getName());
        if (request.isUserInRole(Role.ADMIN.toString())) {
            account = "admin-account";
        }
        if (request.isUserInRole(Role.CLIENT.toString())) {
            account = "client-account";
        }
        if (request.isUserInRole(Role.EMPLOYEE.toString())) {
            account = "employee-account";
        }
        model.addAttribute("user", userService.getCurrentUser());
        return account;
    }
}
