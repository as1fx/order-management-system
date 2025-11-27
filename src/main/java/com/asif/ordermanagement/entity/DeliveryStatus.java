package com.asif.ordermanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Entity
@Table(name="delivery_status")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DeliveryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="delivery_id", nullable = false)
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private DeliveryState status = DeliveryState.ASSIGNED;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    public enum DeliveryState{
        ASSIGNED,
        PICKED_UP,
        ON_THE_WAY,
        DELIVERED,
        FAILED
    }
}
