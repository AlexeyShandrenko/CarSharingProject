package ru.itis.carsharingproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.carsharingproject.dto.UserForm;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.UserPhoto;
import ru.itis.carsharingproject.repositories.UsersRepository;
import ru.itis.carsharingproject.utils.EmailUtil;
import ru.itis.carsharingproject.utils.MailsGenerator;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.subject}")
    private String subject;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .firstname(userForm.getFirstname())
                .lastname(userForm.getLastname())
                .email(userForm.getEmail())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .age(userForm.getAge())
                .confirm_code(UUID.randomUUID().toString())
                .status(User.Status.UNCONFIRMED)
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .city(userForm.getCity())
                .build();

        usersRepository.save(newUser);

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirm_code());

        emailUtil.sendEmail(newUser.getEmail(), subject, from, confirmMail);
    }

}
