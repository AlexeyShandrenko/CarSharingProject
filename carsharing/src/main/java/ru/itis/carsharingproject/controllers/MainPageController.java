package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.dto.UserContactForm;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.security.details.UserDetailsImpl;
import ru.itis.carsharingproject.services.OrdersService;
import ru.itis.carsharingproject.services.UsersService;
import ru.itis.carsharingproject.services.VehicleService;

import java.util.List;
import java.util.Optional;

@Controller
public class MainPageController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/main_page")
    public String getMainPage(@AuthenticationPrincipal UserDetailsImpl user) {
        return "index";
    }

    @GetMapping("/about_page")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/services")
    public String getServicePage() {
        return "services";
    }

    @GetMapping("/car_page")
    public String getCarPage(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        return "car_page";
    }

    @GetMapping("/contacts")
    public String getContactPage() {
        return "contacts";
    }

    @PostMapping("/contacts")
    public String sendMessageToEmail(UserContactForm userContactForm) {
        usersService.sendContactEmail(userContactForm);
        return "redirect:/main_page";
    }

    @GetMapping("/contacts&error")
    public String getContactError() {
        return "contact_error";
    }

    @PostMapping("/addCarOnMainPage")
    public String bookCarOnMainPage(@AuthenticationPrincipal UserDetailsImpl userDetails, OrdersDto ordersDto) {
        User user1 = usersService.findUserById(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
        ordersDto.setUser_id(user1.getId());
        ordersDto.setCity(userDetails.getUser().getCity());
        ordersService.bookCarOnMainPage(ordersDto);
        return "redirect:/add_car";

    }

    @GetMapping("/add_car")
    public String getAddCarPage(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        return "add_car";
    }

    @PostMapping("/add_car/{vehicle-id}")
    public String addCar(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("vehicle-id") Long id, Vehicle vehicle) throws IllegalAccessException {
        User user1 = usersService.findUserById(user.getUser().getId()).orElseThrow(IllegalAccessError::new);
        vehicle = vehicleService.findVehicleById(id).orElseThrow(IllegalAccessError::new);
        ordersService.addCarOnAddCarPage(vehicle, user1);
        return "redirect:/orders";
    }

}
