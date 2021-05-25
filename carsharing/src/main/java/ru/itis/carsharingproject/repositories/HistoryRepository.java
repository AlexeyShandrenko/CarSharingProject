package ru.itis.carsharingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.carsharingproject.models.History;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {
//    Optional<History> findByOwnerId(Long id);
    List<History> findByOwnerId(Long id);

    @Query(nativeQuery = true, value = "delete from history where user_id = :id")
    void deleteByOwnerId(Long id);
}
