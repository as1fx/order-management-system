package com.asif.ordermanagement.repository;

import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    Optional<Delivery> findByOrder(Order order);
    Optional<Delivery> findByOrderId(Integer orderId);
}
