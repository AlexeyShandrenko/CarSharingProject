package ru.itis.carsharingproject.services;

import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void bookCarOnMainPage(OrdersDto ordersDto);

    void addCarOnAddCarPage(Vehicle vehicle, User user) throws IllegalAccessException;

    List<Orders> findAll();
}
