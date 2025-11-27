package com.asif.ordermanagement.dto.Restaurant;

import lombok.Data;

@Data
public class RestaurantResponse {
    private Integer id;
    private String name;
    private String address;
    private String status;
    private Integer adminId;
}
