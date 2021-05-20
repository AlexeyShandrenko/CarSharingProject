package ru.itis.carsharingproject.utils;

public interface MailsGenerator {

    String getMailForConfirm(String serverUrl, String code);

    String getMailForContact(String firstname, String email, String subject, String description);

}
