package com.asif.ordermanagement.dto.Menu;

import lombok.Data;

@Data
public class MenuItemRequest {
    private String name;
    private String description;
    private Double price;
    private Integer restaurantId;
    private Boolean available;
}
