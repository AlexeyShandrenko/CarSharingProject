package ru.itis.carsharingproject.utils;

import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.models.Vehicle;

import javax.persistence.criteria.Order;
import java.util.Optional;

public interface MailsGenerator {

    String getMailForConfirm(String serverUrl, String code);

    String getMailForContact(String firstname, String email, String subject, String description);

    String getMailForOrder(String firstname, String lastname, String url, String vehicleName, Integer VehiclePrice, String orderCity, String location, String pick_date, String return_date);

}
