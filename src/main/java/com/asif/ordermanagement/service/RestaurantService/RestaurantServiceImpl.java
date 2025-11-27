package com.asif.ordermanagement.service.RestaurantService;

import com.asif.ordermanagement.dto.Restaurant.RestaurantResponse;
import com.asif.ordermanagement.entity.Restaurant;
import com.asif.ordermanagement.entity.User;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.mapper.Restaurant.RestaurantMapper;
import com.asif.ordermanagement.repository.RestaurantRepository;
import com.asif.ordermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Override
    public RestaurantResponse createRestaurant(Restaurant request) {
        User admin = userRepository.findById(request.getAdmin().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found"));

        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setAdmin(admin);

        restaurantRepository.save(restaurant);

        return RestaurantMapper.toResponse(restaurant);
    }

    @Override
    public List<RestaurantResponse> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(RestaurantMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantResponse getRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        return RestaurantMapper.toResponse(restaurant);
    }
}
