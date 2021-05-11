package ru.itis.carsharingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.carsharingproject.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}
