package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.Menu.MenuItemRequest;
import com.asif.ordermanagement.dto.Menu.MenuItemResponse;
import com.asif.ordermanagement.entity.MenuItem;
import com.asif.ordermanagement.entity.Restaurant;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.mapper.Menu.MenuItemMapper;
import com.asif.ordermanagement.service.MenuItem.MenuItemService;
import com.asif.ordermanagement.service.MenuItem.MenuItemServiceImpl;
import com.asif.ordermanagement.service.RestaurantService.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemServiceImpl menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemResponse> addMenuItem(@RequestBody MenuItemRequest request) {
        MenuItemResponse response = menuItemService.createMenuItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItemResponse>> getMenuByRestaurant(@PathVariable Integer restaurantId) {
        List<MenuItemResponse> menu = menuItemService.getMenuByRestaurantId(restaurantId);
        return ResponseEntity.ok(menu);
    }
}
