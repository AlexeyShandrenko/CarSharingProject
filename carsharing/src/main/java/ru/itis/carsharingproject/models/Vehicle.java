package ru.itis.carsharingproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "class_id")
    private VehicleClass vehicleClass;
    @ManyToOne()
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;
    private String transmission;
    private String drive_type;
    private String tank_capacity;
    private String fuel_consumption;
    private String acceleration_time;
    private String max_speed;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private VehiclePhoto vehiclePhoto;
    @ManyToOne()
    @JoinColumn(name = "producer_id")
    private Producer producer;
    @OneToMany(mappedBy = "vehicle")
    private List<Orders> ordersList;



}