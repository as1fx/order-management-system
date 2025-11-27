package com.asif.ordermanagement.repository;

import com.asif.ordermanagement.entity.MenuItem;
import com.asif.ordermanagement.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findByRestaurant(Restaurant restaurant);
    List<MenuItem> findByRestaurantId(Integer restaurantId);
}
