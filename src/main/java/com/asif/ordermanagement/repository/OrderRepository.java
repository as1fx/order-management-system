package com.asif.ordermanagement.repository;

import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.Restaurant;
import com.asif.ordermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomer(User customer);
    List<Order> findByRestaurant(Restaurant restaurant);

    List<Order> findByStatus(Order.OrderStatus status);
}
