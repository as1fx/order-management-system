package com.asif.ordermanagement.mapper.Restaurant;

import com.asif.ordermanagement.dto.Restaurant.RestaurantResponse;
import com.asif.ordermanagement.entity.Restaurant;

public class RestaurantMapper {
    public static RestaurantResponse toResponse(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setAddress(restaurant.getAddress());
        response.setStatus(restaurant.getStatus().name());
        response.setAdminId(restaurant.getAdmin().getId());
        return response;
    }
}
