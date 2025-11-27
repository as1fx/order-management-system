package com.asif.ordermanagement.service.Order;

import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.OrderItem;
import com.asif.ordermanagement.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderItemService {
    OrderItem createOrderItem(OrderItem item);
    List<OrderItem> getItemsByOrder(Integer orderId);
}
