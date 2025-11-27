package com.asif.ordermanagement.dto.Menu;

import lombok.Data;

@Data
public class MenuItemResponse {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer restaurantId;
    private Boolean available;
}
