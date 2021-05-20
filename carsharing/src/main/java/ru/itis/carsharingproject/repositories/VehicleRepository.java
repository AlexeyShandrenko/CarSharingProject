package ru.itis.carsharingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.carsharingproject.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
