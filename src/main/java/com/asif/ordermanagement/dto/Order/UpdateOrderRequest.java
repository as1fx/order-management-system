package com.asif.ordermanagement.dto.Order;

import lombok.Data;

@Data
public class UpdateOrderRequest {
    private Integer orderId;
    private Integer menuItemId;
    private Integer quantity;
    private String orderStatus;
    private String paymentStatus;


}
