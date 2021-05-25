package ru.itis.carsharingproject.services;

import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> findAll();

    Optional<Vehicle> findById(Long id);


}
