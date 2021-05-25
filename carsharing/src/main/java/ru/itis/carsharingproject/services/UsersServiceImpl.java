package ru.itis.carsharingproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.carsharingproject.dto.UserContactForm;
import ru.itis.carsharingproject.dto.UserDto;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.repositories.UsersRepository;
import ru.itis.carsharingproject.utils.EmailUtil;
import ru.itis.carsharingproject.utils.MailsGenerator;

import java.util.List;
import java.util.Optional;

import static ru.itis.carsharingproject.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.contact}")
    private String subject;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void editUserStatus(User user) {
        User activateUser = usersRepository.findById(user.getId()).orElseThrow(IllegalAccessError::new);
        activateUser.setStatus(User.Status.CONFIRMED);
        usersRepository.save(activateUser);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAllByIsDeletedIsNull());
    }

    @Override
    public void sendContactEmail(UserContactForm userContactForm) {

        String message = mailsGenerator.getMailForContact(userContactForm.getFirstname(), userContactForm.getEmail(), userContactForm.getSubject(), userContactForm.getDescription());

        emailUtil.sendEmail(userContactForm.getEmail(), subject, from, message);

    }

    @Override
    public void addUserPhone(UserDto userDto) {
        User user = usersRepository.findById(userDto.getId()).orElseThrow(IllegalAccessError::new);

        user.setPhone(userDto.getPhone());

        usersRepository.save(user);
    }

    @Override
    public void addUserCity(UserDto userDto) {
        User user = usersRepository.findById(userDto.getId()).orElseThrow(IllegalAccessError::new);

        user.setCity(userDto.getCity());

        usersRepository.save(user);
    }

    @Override
    public void editProfile(UserDto userDto) {
        User user = usersRepository.findById(userDto.getId()).orElseThrow(IllegalAccessError::new);
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setCity(userDto.getCity());
        usersRepository.save(user);

    }

    @Override
    public void editImage(UserDto userDto) {
        User user = usersRepository.findById(userDto.getId()).orElseThrow(IllegalAccessError::new);
        user.setUserPhoto(userDto.getUserPhoto());
        usersRepository.save(user);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User newUser = User.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .city(userDto.getCity())
                .build();

        usersRepository.save(newUser);
        return from(newUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User userForUpdate = usersRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        userForUpdate.setFirstname(userDto.getFirstname());
        userForUpdate.setLastname(userDto.getLastname());
        userForUpdate.setPhone(userDto.getPhone());
        userForUpdate.setCity(userDto.getCity());
        usersRepository.save(userForUpdate);
        return from(userForUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        User userForDelete = usersRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        userForDelete.setIsDeleted(true);
        usersRepository.save(userForDelete);
    }


}
