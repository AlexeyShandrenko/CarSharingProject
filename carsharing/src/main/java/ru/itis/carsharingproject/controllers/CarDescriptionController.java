package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.security.details.UserDetailsImpl;
import ru.itis.carsharingproject.services.VehicleService;

import java.util.List;

@Controller
public class CarDescriptionController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/car_description")
    public String getCarDescriptionPage(Model model) {
//        List<Vehicle> vehicles = vehicleService.findAll();
//        model.addAttribute("vehicles", vehicles);
        return "car_description";
    }

}
