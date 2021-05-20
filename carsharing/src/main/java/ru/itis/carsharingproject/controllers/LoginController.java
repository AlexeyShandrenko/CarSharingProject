package ru.itis.carsharingproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/sign_in")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/sign_in&error")
    public String getErrorPage() {
        return "error_page";
    }


}
