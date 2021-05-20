package ru.itis.carsharingproject.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntryPageController {

    @GetMapping("/")
    public String getEntryPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/main_page";
        } else {
            return "redirect:/base_page";
        }
    }

}
