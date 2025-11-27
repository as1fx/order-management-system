package com.asif.ordermanagement.dto.DeliveryStatus;

import lombok.Data;

@Data
public class DeliveryStatusRequest {
    private Integer deliveryId;
    private String status;
}
