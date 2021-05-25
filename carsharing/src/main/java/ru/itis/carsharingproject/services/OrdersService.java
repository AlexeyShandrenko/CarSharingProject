package ru.itis.carsharingproject.services;

import org.hibernate.criterion.Order;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.dto.VehicleDto;
import ru.itis.carsharingproject.models.History;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void bookCarOnCarPage(Vehicle vehicle, OrdersDto ordersDto);

    void fillForm(OrdersDto ordersDto);

    List<Orders> findAll();

    Optional<Orders> findByOwnerId(Long id);

    Optional<Orders> findById(Long id);

    void deleteOrderByOwnerId(Long id);

    void deleteById(Long id);

    void returnOrder(History history);

    Optional<Orders> findByOwnerIdAndVehicleId(Long id1, Long id2);

    void addCarOnAddCarPage(Vehicle vehicle, User user);

    void bookCarOnMainPage(OrdersDto ordersDto);

}
