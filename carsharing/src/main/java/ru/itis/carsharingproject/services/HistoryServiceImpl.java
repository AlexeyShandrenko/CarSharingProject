package ru.itis.carsharingproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.carsharingproject.models.History;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.repositories.HistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void addOrder(Orders orders) {
        History newOrder = History.builder()
                .history_id(orders.getOrder_id())
                .city(orders.getCity())
                .location(orders.getLocation())
                .owner(orders.getOwner())
                .pick_date(orders.getPick_date())
                .return_date(orders.getReturn_date())
                .price(orders.getPrice())
                .vehicle(orders.getVehicle())
                .build();

        historyRepository.save(newOrder);
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public List<History> findByUserId(Long id) {
        return historyRepository.findByOwnerId(id);
    }

    @Override
    public Optional<History> findByUserIdOptional(Long id) {
        return historyRepository.findById(id);
    }

    @Override
    public void clearHistoryByUserId(Long id) {
        historyRepository.deleteByOwnerId(id);
    }

    @Override
    public Optional<History> findById(Long id) {
        return historyRepository.findById(id);
    }


}
