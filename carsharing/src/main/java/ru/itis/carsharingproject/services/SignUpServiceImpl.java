package ru.itis.carsharingproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.carsharingproject.dto.UserForm;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.repositories.UsersRepository;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .firstname(userForm.getFirstname())
                .lastname(userForm.getLastname())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .age(userForm.getAge())
                .confirm_code(UUID.randomUUID().toString())
                .status(User.Status.UNCONFIRMED)
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();

        usersRepository.save(newUser);
    }
}
