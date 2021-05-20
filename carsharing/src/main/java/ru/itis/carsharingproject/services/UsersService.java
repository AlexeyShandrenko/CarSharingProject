package ru.itis.carsharingproject.services;

import ru.itis.carsharingproject.dto.UserContactForm;
import ru.itis.carsharingproject.dto.UserDto;
import ru.itis.carsharingproject.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    List<UserDto> getAllUsers();

    void sendContactEmail(UserContactForm userContactForm);

    void addUserPhone(UserDto userDto);

    void addUserCity(UserDto userDto);

    void editProfile(UserDto userDto);

    UserDto addUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    void editImage(UserDto userDto);



}
