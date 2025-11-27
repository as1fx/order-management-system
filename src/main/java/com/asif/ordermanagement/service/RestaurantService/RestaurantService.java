package com.asif.ordermanagement.service.RestaurantService;

import com.asif.ordermanagement.dto.Restaurant.RestaurantResponse;
import com.asif.ordermanagement.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    RestaurantResponse createRestaurant(Restaurant request);
    List<RestaurantResponse> getAllRestaurants();
    RestaurantResponse getRestaurantById(Integer id);
}
