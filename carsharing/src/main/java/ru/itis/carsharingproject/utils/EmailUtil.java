package ru.itis.carsharingproject.utils;

import org.springframework.stereotype.Component;

public interface EmailUtil {

    void sendEmail(String to, String subject, String from, String text);

}
