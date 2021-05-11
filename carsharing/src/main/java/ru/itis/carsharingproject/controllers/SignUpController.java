package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.carsharingproject.dto.UserForm;
import ru.itis.carsharingproject.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/sign_up")
    public String getSignUpPage() {
        return "registration";
    }

    @PostMapping("/sign_up")
    public String signUp(UserForm userForm) {
        signUpService.signUp(userForm);
        return "redirect:/sign_up";
    }

}
