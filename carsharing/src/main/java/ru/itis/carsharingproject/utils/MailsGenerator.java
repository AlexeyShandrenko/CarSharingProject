package ru.itis.carsharingproject.utils;

public interface MailsGenerator {

    String getMailForConfirm(String serverUrl, String code);

}
