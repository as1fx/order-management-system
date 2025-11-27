package com.asif.ordermanagement.mapper.Order;

import com.asif.ordermanagement.dto.Order.OrderItemResponse;
import com.asif.ordermanagement.dto.Order.OrderResponse;
import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.OrderItem;

public class OrderMapper {
    public static OrderResponse toOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCustomerId(order.getCustomer().getId());
        response.setRestaurantId(order.getRestaurant().getId());
        response.setTotalAmount(order.getTotalAmount().doubleValue());
        response.setPaymentStatus(order.getPaymentStatus().name());
        response.setOrderStatus(order.getStatus().name());

        return response;
    }

    public static OrderItemResponse toOrderItemResponse(OrderItem orderItem) {
        OrderItemResponse response = new OrderItemResponse();
        response.setId(orderItem.getId());
        response.setOrderId(orderItem.getOrder().getId());
        response.setMenuItemId(orderItem.getMenuItem().getId());
        response.setQuantity(orderItem.getQuantity());
        response.setPrice(orderItem.getPrice().doubleValue());

        return response;
    }
}
