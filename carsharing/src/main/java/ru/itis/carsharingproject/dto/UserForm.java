package ru.itis.carsharingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.carsharingproject.validation.ValidAge;
import ru.itis.carsharingproject.validation.ValidMatchPassword;
import ru.itis.carsharingproject.validation.ValidNames;
import ru.itis.carsharingproject.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidNames(message = "{errors.invalid.names}", name = "firstname", surname = "lastname")
@ValidMatchPassword(message = "{errors.incorrect.passwords}", password = "password", password_repeat = "password_repeat")
public class UserForm {

    private String firstname;
    private String lastname;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.incorrect.password}")
    private String password;
    private String password_repeat;
    @ValidAge(message = "{errors.invalid.age}")
    private Integer age;
    private String city;

}
