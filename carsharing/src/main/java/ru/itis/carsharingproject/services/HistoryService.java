package ru.itis.carsharingproject.services;

import ru.itis.carsharingproject.models.History;
import ru.itis.carsharingproject.models.Orders;

import java.util.List;
import java.util.Optional;

public interface HistoryService {

    void addOrder(Orders orders);

    List<History> findAll();

    List<History> findByUserId(Long id);

    Optional<History> findByUserIdOptional(Long id);

    void clearHistoryByUserId(Long id);

    Optional<History> findById(Long id);

}
