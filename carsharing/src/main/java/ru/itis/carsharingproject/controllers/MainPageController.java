package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.dto.UserContactForm;
import ru.itis.carsharingproject.dto.VehicleDto;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.security.details.UserDetailsImpl;
import ru.itis.carsharingproject.services.OrdersService;
import ru.itis.carsharingproject.services.UsersService;
import ru.itis.carsharingproject.services.VehicleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MainPageController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/main_page")
    public String getMainPage(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
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
    public String getCarPage(Model model, Authentication authentication) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
        return "car_page";
    }

    @GetMapping("car_page/{vehicle-id}")
    public String addCarOnCarPage(OrdersDto ordersDto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("vehicle-id") Long id) {

        Optional<Orders> orders = ordersService.findByOwnerId(userDetails.getUser().getId());
        orders.ifPresent(value -> ordersService.deleteById(value.getOrder_id()));

            User user1 = usersService.findUserById(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
            ordersDto.setUser_id(user1.getId());
            if (user1.getCity() != null) {
                ordersDto.setCity(user1.getCity());
            } else {
                return "redirect:/profile";
            }
            Vehicle vehicle = vehicleService.findById(id).orElseThrow(IllegalAccessError::new);
            ordersService.bookCarOnCarPage(vehicle, ordersDto);
            return "redirect:/add_form";
    }

    @GetMapping("/add_form")
    public String getAddFormPage() {
        return "add_form";
    }


    @PostMapping("/car_page_form")
    public String fillForm(OrdersDto ordersDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Orders orders = ordersService.findByOwnerId(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
        ordersDto.setUser_id(orders.getOwner().getId());
        ordersService.fillForm(ordersDto);
        return "redirect:/orders";
    }

    @GetMapping("/contacts")
    public String getContactPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = usersService.findUserById(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
        model.addAttribute("name", user.getFirstname());
        return "contacts";
    }

//    @PostMapping("/contacts")
//    public String sendMessageToEmail(UserContactForm userContactForm) {
//        usersService.sendContactEmail(userContactForm);
//        return "redirect:/main_page";
//    }
//
//    @GetMapping("/contacts&error")
//    public String getContactError() {
//        return "contact_error";
//    }

    @PostMapping("/addCarOnMainPage")
    public String bookCarOnMainPage(@AuthenticationPrincipal UserDetailsImpl userDetails, OrdersDto ordersDto, HttpServletRequest httpServletRequest) {
        Optional<Orders> orders = ordersService.findByOwnerId(userDetails.getUser().getId());
        orders.ifPresent(value -> ordersService.deleteById(value.getOrder_id()));

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


    @GetMapping("/add_car/{vehicle-id}")
    public String addCar(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("vehicle-id") Long id, Vehicle vehicle) throws IllegalAccessException {
        User user1 = usersService.findUserById(user.getUser().getId()).orElseThrow(IllegalAccessError::new);
        vehicle = vehicleService.findById(id).orElseThrow(IllegalAccessError::new);
        ordersService.addCarOnAddCarPage(vehicle, user1);
        return "redirect:/orders";
    }

}
