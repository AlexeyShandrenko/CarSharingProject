package ru.itis.carsharingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.carsharingproject.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    List<User> findAllByIsDeletedIsNull();

}
