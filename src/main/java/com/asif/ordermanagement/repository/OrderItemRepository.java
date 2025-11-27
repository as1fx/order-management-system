package com.asif.ordermanagement.repository;

import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrder(Order order);
}
