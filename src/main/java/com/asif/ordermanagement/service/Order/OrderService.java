package com.asif.ordermanagement.service.Order;

import com.asif.ordermanagement.dto.Order.OrderRequest;
import com.asif.ordermanagement.dto.Order.OrderResponse;
import com.asif.ordermanagement.dto.Order.UpdateOrderRequest;
import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.User;
import com.asif.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    OrderResponse addItem(Integer orderId, Integer menuItemId, Integer quantity);
    List<OrderResponse> getCustomerOrders(Integer customerId);
    OrderResponse getOrderById(Integer id);
    OrderResponse updateOrder(Integer orderId, UpdateOrderRequest request);
}
