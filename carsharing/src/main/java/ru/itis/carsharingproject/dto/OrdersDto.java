package ru.itis.carsharingproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.carsharingproject.models.Orders;
import ru.itis.carsharingproject.models.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {

    private Long user_id;
    private String location;
    private String pick_date;
    private String return_date;
    private String city;
    private Integer price;
    private Long vehicle_id;


}
