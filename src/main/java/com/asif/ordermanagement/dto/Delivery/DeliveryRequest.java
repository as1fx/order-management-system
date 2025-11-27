package com.asif.ordermanagement.dto.Delivery;

import lombok.Data;

@Data
public class DeliveryRequest {
    private Integer orderId;
    private Integer deliveryPartnerId;
}
