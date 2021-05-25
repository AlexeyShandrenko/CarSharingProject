package ru.itis.carsharingproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long history_id;
    private String location;
    private String city;
    private Integer price;
    private String pick_date;
    private String return_date;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
