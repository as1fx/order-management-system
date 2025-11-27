package com.asif.ordermanagement.service.MenuItem;

import com.asif.ordermanagement.dto.Menu.MenuItemRequest;
import com.asif.ordermanagement.dto.Menu.MenuItemResponse;
import com.asif.ordermanagement.entity.MenuItem;
import com.asif.ordermanagement.entity.Restaurant;
import com.asif.ordermanagement.mapper.Menu.MenuItemMapper;
import com.asif.ordermanagement.repository.MenuItemRepository;
import com.asif.ordermanagement.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public MenuItemResponse createMenuItem(MenuItemRequest request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        MenuItem item = new MenuItem();
        item.setRestaurant((restaurant));
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPrice(BigDecimal.valueOf(request.getPrice()));
        item.setAvailable(request.getAvailable() != null ? request.getAvailable() : true);

        menuItemRepository.save(item);

        return MenuItemMapper.toResponse(item);
    }

    @Override
    public List<MenuItemResponse> getMenuByRestaurantId(Integer restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId).stream()
                .map(MenuItemMapper::toResponse)
                .collect(Collectors.toList());
    }
}
