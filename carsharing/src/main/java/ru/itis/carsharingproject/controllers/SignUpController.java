package ru.itis.carsharingproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping("/sign_up")
    public String getSignUpPage() {
        return "registration";
    }

}
