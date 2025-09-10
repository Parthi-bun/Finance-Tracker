package com.example.FinanceTracker.controller;

import com.example.FinanceTracker.model.User;
import com.example.FinanceTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationProcess(@ModelAttribute("user") User user, Model model){
        user.setRole("ROLE_USER");
        userService.saveUser(user);
        return "redirect:/login";
    }
}
