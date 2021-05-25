package ru.itis.carsharingproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.carsharingproject.dto.OrdersDto;
import ru.itis.carsharingproject.dto.VehicleDto;
import ru.itis.carsharingproject.models.History;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;
import ru.itis.carsharingproject.repositories.OrdersRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;



    @Override
    public void bookCarOnCarPage(Vehicle vehicle, OrdersDto ordersDto) {
        Orders newOrder = Orders.builder()
                .owner(User.builder()
                        .id(ordersDto.getUser_id())
                        .build())
                .city(ordersDto.getCity())
                .price(vehicle.getPrice())
                .vehicle(vehicle)
                .build();

        ordersRepository.save(newOrder);
    }

    @Override
    public void fillForm(OrdersDto ordersDto) {
        Orders ordersForUpdate = ordersRepository.findByOwnerId(ordersDto.getUser_id()).orElseThrow(IllegalAccessError::new);
        ordersForUpdate.setLocation(ordersDto.getLocation());
        ordersForUpdate.setPick_date(ordersDto.getPick_date());
        ordersForUpdate.setReturn_date(ordersDto.getReturn_date());
        ordersRepository.save(ordersForUpdate);
    }


    @Override
    public void returnOrder(History history) {
        Orders returnOrder = Orders.builder()
                .vehicle(history.getVehicle())
                .return_date(history.getReturn_date())
                .pick_date(history.getPick_date())
                .order_id(history.getHistory_id())
                .price(history.getPrice())
                .city(history.getCity())
                .location(history.getLocation())
                .owner(history.getOwner())
                .build();
        ordersRepository.save(returnOrder);
    }

    @Override
    public Optional<Orders> findByOwnerIdAndVehicleId(Long id1, Long id2) {
        return ordersRepository.findByOwnerIdAndAndVehicleId(id1, id2);
    }

    @Override
    public void addCarOnAddCarPage(Vehicle vehicle, User user) {
        Orders orders = ordersRepository.findByOwnerId(user.getId()).orElseThrow(IllegalAccessError::new);
        orders.setVehicle(vehicle);
        orders.setPrice(vehicle.getPrice());
        ordersRepository.save(orders);

    }

    @Override
    public void bookCarOnMainPage(OrdersDto ordersDto) {
        Orders newOrder = Orders.builder()
                .return_date(ordersDto.getReturn_date())
                .pick_date(ordersDto.getPick_date())
                .location(ordersDto.getLocation())
                .city(ordersDto.getCity())
                .owner(User.builder()
                        .id(ordersDto.getUser_id())
                        .build())
                .build();

        ordersRepository.save(newOrder);
    }

//    @Override
//    public void addCarOnAddCarPage(Orders orders, Vehicle vehicle) throws IllegalAccessException {
//        Orders order1 = ordersRepository.findById(orders.getOrder_id()).orElseThrow(IllegalAccessError::new);
//        order1.setVehicle(orders.getVehicle());
//        order1.setPrice(vehicle.getPrice());
//        ordersRepository.save(order1);
//    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findByOwnerId(Long id) {
        return ordersRepository.findByOwnerId(id);
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public void deleteOrderByOwnerId(Long id) {
        ordersRepository.deleteByOwnerId(id);
    }

    @Override
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }


}
