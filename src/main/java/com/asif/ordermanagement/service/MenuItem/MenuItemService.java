package com.asif.ordermanagement.service.MenuItem;

import com.asif.ordermanagement.dto.Menu.MenuItemRequest;
import com.asif.ordermanagement.dto.Menu.MenuItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuItemService {
    MenuItemResponse createMenuItem(MenuItemRequest request);
    List<MenuItemResponse> getMenuByRestaurantId(Integer restaurantId);
}
