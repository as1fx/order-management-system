package com.asif.ordermanagement.dto.DeliveryStatus;

import lombok.Data;

@Data
public class DeliveryStatusResponse {
    private Integer id;
    private Integer deliveryId;
    private String status;
    private String updatedAt;

}
