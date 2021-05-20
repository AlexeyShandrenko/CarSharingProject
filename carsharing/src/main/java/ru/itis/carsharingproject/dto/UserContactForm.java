package ru.itis.carsharingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserContactForm {

    private String firstname;
    private String email;
    private String subject;
    private String description;

}
