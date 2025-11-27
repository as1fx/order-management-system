package com.asif.ordermanagement.dto.Order;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Integer id;
    private Integer orderId;
    private Integer menuItemId;
    private Integer quantity;
    private Double price;
}
