package com.services.myappointmentmonolithtic.controller;

import com.services.myappointmentmonolithtic.service.ProvidedServiceServise;
import com.services.myappointmentmonolithtic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserService userService;
    private ProvidedServiceServise providedServiceServise;

    public LoginController(UserService userService, ProvidedServiceServise providedServiceServise) {
        this.userService = userService;
        this.providedServiceServise = providedServiceServise;
    }

    @GetMapping()
    public String login(){
        return "login-page";
    }

    @PostMapping("login-page")
    public String login(@RequestParam String login,
                        @RequestParam String password,
                        Model model) {
        userService.setCurrentUser(login,password);
        model.addAttribute("services", providedServiceServise.getAllProvidedServices());
        model.addAttribute("user", userService.getCurrentUser());
        return "redirect:/account";
    }
}
