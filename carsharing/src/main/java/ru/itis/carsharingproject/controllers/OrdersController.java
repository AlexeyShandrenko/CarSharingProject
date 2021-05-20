package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.security.details.UserDetailsImpl;
import ru.itis.carsharingproject.services.OrdersService;
import ru.itis.carsharingproject.services.UsersService;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public String getOrderPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        List<Orders> orders = ordersService.findAll();
        model.addAttribute("orders", orders);
        return "orders_page";
    }

}
