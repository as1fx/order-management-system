package com.asif.ordermanagement.dto.Restaurant;

import lombok.Data;

@Data
public class RestaurantRequest {
    private String name;
    private String address;
    private Integer adminId;
}
