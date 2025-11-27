package com.asif.ordermanagement.repository;

import com.asif.ordermanagement.entity.Restaurant;
import com.asif.ordermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findByStatus(Restaurant.RestaurantStatus status);
    List<Restaurant> findByAdmin(User admin);
}
