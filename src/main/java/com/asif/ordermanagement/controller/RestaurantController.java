package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.Restaurant.RestaurantRequest;
import com.asif.ordermanagement.dto.Restaurant.RestaurantResponse;
import com.asif.ordermanagement.entity.Restaurant;
import com.asif.ordermanagement.entity.User;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.service.RestaurantService.RestaurantService;
import com.asif.ordermanagement.service.RestaurantService.RestaurantServiceImpl;
import com.asif.ordermanagement.service.User.UserService;
import com.asif.ordermanagement.service.User.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantRequest request) {
        User admin = userService.getUserById(request.getAdminId());
        if (admin == null) {
            throw new ResourceNotFoundException("Admin user not found");
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setAdmin(admin);
        restaurant.setStatus(Restaurant.RestaurantStatus.OPEN);
        restaurant.setTimestamp(new Timestamp(System.currentTimeMillis()));

        RestaurantResponse response = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants() {
        List<RestaurantResponse> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Integer id) {
        RestaurantResponse restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }
}
