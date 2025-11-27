package com.asif.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name="restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="admin_id", nullable = false)
    private User admin;

    @Enumerated(EnumType.STRING)
    private RestaurantStatus  status = RestaurantStatus.OPEN;

    @Column(name="created_at")
    private Timestamp timestamp;

    public enum RestaurantStatus{
        OPEN,
        CLOSED
    }

}
