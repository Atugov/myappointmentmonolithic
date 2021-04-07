package com.services.myappointmentmonolithtic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomePageController {
    


        @GetMapping()
        public String getHomePage(){
        return "home";
        }

    @PostMapping("/login")
    public String getAccount(@RequestParam String login, @RequestParam String password, Model model) {

        model.addAttribute("users");
        return "account";
    }
}
