package ru.itis.carsharingproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.repositories.OrdersRepository;
import ru.itis.carsharingproject.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void bookCarOnMainPage(OrdersDto ordersDto) {
        Orders newOrder = Orders.builder()
                .owner(User.builder()
                        .id(ordersDto.getUser_id())
                        .build())
                .city(ordersDto.getCity())
                .location(ordersDto.getLocation())
                .pick_date(ordersDto.getPick_date())
                .return_date(ordersDto.getReturn_date())
                .build();

        ordersRepository.save(newOrder);

    }

    @Override
    public void addCarOnAddCarPage(Vehicle vehicle, User user) throws IllegalAccessException {
        Orders orders = ordersRepository.findByOwnerId(user.getId()).orElseThrow(IllegalAccessException::new);
        orders.setVehicle(vehicle);
        orders.setPrice(vehicle.getPrice());
        ordersRepository.save(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }


}
