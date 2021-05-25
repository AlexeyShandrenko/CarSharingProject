package ru.itis.carsharingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(nativeQuery = true, value = "select * from orders where user_id = :id")
    Optional<Orders> findByOwnerId(Long id);
    Optional<Orders> findByOwnerIdAndAndVehicleId(Long id1, Long id2);

    @Query(nativeQuery = true, value = "delete from orders where user_id = :id")
    void deleteByOwnerId(Long id);


}
