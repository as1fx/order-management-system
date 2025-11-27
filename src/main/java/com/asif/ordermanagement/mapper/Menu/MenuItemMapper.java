package com.asif.ordermanagement.mapper.Menu;

import com.asif.ordermanagement.dto.Menu.MenuItemResponse;
import com.asif.ordermanagement.entity.MenuItem;

public class MenuItemMapper {
    public static MenuItemResponse toResponse(MenuItem menuItem) {
        MenuItemResponse response = new MenuItemResponse();
        response.setId(menuItem.getId());
        response.setName(menuItem.getName());
        response.setDescription(menuItem.getDescription());
        response.setPrice(menuItem.getPrice().doubleValue());
        response.setAvailable(menuItem.getAvailable());
        return response;
    }
}
