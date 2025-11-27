package com.asif.ordermanagement.dto.Order;

import lombok.Data;

@Data
public class OrderRequest {
    private Integer customerId;
    private Integer restaurantId;
}
