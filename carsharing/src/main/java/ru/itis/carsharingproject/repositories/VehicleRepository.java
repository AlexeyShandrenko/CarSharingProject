package ru.itis.carsharingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.carsharingproject.models.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
//    @Query(
//            nativeQuery = true,
//            value = "insert into cart values (:user_id, :vehicle_id)"
//    )
//    void save(Long user_id, Long vehicle_id);
//
//    @Query(
//            nativeQuery = true,
//            value = "select * from cart join vehicle v on v.id = cart.vehicle_id where user_id = :user_id"
//    )
//    List<Vehicle> findByCart(Long user_id);
}
