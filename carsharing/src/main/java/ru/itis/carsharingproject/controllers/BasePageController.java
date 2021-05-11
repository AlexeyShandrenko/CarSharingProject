package ru.itis.carsharingproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasePageController {

    @GetMapping("/")
    public String getBasePage() {
        return "base_page";
    }

}
