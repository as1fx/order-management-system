package com.asif.ordermanagement.dto.Order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Integer id;
    private Integer customerId;
    private Integer restaurantId;
    private Double totalAmount;
    private String paymentStatus;
    private String orderStatus;
    private LocalDateTime orderTime;
}
