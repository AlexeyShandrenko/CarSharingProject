package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.models.History;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.security.details.UserDetailsImpl;
import ru.itis.carsharingproject.services.HistoryService;
import ru.itis.carsharingproject.services.OrdersService;
import ru.itis.carsharingproject.services.UsersService;
import ru.itis.carsharingproject.services.VehicleService;
import ru.itis.carsharingproject.utils.EmailUtil;
import ru.itis.carsharingproject.utils.MailsGenerator;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@Controller
public class OrdersController {

    @Autowired
    private MailsGenerator mailsGenerator;

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.confirm}")
    private String subject;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/orders")
    public String getOrderPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        Optional<Orders> orders = ordersService.findByOwnerId(user.getUser().getId());
        if (orders.isPresent()) {
            model.addAttribute("orders", orders);
        }
            return "orders_page";
    }



    @GetMapping("/order_delete/{order_id}")
    public String DeleteOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("order_id") Long id) {
        Orders orders = ordersService.findById(id).orElseThrow(IllegalAccessError::new);
        historyService.addOrder(orders);
        ordersService.deleteById(orders.getOrder_id());
        return "orders_page";
    }

    @PermitAll
    @GetMapping("/order_confirm/{order-id}")
    public String confirmCar(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("order-id") Long id) {
        Orders orders = ordersService.findByOwnerId(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
        historyService.addOrder(orders);
        ordersService.deleteById(orders.getOrder_id());
        User newUser = usersService.findUserById(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
        String confirmMail = mailsGenerator.getMailForOrder(newUser.getFirstname(), newUser.getLastname(), orders.getVehicle().getVehiclePhoto().getUrl(),
                orders.getVehicle().getName(), orders.getVehicle().getPrice(), orders.getCity(), orders.getLocation(),
                orders.getPick_date(), orders.getReturn_date());
        emailUtil.sendEmail(newUser.getEmail(), subject, from, confirmMail);
        return "order_success";
    }

    @GetMapping("/history")
    public String getHistoryPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<History> historyList = historyService.findByUserId(userDetails.getUser().getId());
        if (historyList != null) {
            model.addAttribute("historyList", historyList);
        } else {
            return "redirect:/main_page";
        }
        return "history";
    }

    @GetMapping("/history_delete")
    public String clearHistory(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = usersService.findUserById(userDetails.getUser().getId()).orElseThrow(IllegalAccessError::new);
        historyService.clearHistoryByUserId(user.getId());
        return "redirect:/history";
    }

    @GetMapping("/history_return/{history_id}")
    public String returnOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("history_id") Long id) {
        History history = historyService.findById(id).orElseThrow(IllegalAccessError::new);
        Optional<Orders> orders = ordersService.findByOwnerId(userDetails.getUser().getId());
        if (orders.isPresent()) {
            ordersService.deleteById(orders.get().getOrder_id());
        }
        ordersService.returnOrder(history);
        return "orders_page";

    }

}
