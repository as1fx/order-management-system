package com.asif.ordermanagement.dto.Delivery;

import lombok.Data;

@Data
public class DeliveryResponse {
    private Integer id;
    private Integer orderId;
    private Integer deliveryPartnerId;
    private String assignedAt;
}
