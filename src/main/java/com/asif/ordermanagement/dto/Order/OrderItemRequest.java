package com.asif.ordermanagement.dto.Order;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Integer orderId;
    private Integer menuItemId;
    private Integer quantity;
}
