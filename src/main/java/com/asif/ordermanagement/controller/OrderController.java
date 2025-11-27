package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.Order.*;
import com.asif.ordermanagement.dto.Restaurant.RestaurantResponse;
import com.asif.ordermanagement.entity.User;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.service.Order.OrderItemService;
import com.asif.ordermanagement.service.Order.OrderItemServiceImpl;
import com.asif.ordermanagement.service.Order.OrderService;
import com.asif.ordermanagement.service.Order.OrderServiceImpl;
import com.asif.ordermanagement.service.RestaurantService.RestaurantService;
import com.asif.ordermanagement.service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;
    private final OrderItemServiceImpl orderItemService;
    private final UserService userService;
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        User customer = userService.getUserById(orderRequest.getCustomerId());
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found");
        }

        try {
            RestaurantResponse restaurantResponse = restaurantService.getRestaurantById(orderRequest.getRestaurantId());
            if (restaurantResponse == null) {
                throw new ResourceNotFoundException("Restaurant not found");
            }
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Restaurant not found");
        }

        OrderResponse response = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderItemResponse> addOrderItem(
            @PathVariable Integer orderId,
            @RequestBody OrderItemRequest itemRequest) {
        OrderResponse order = orderService.addItem(orderId, itemRequest.getMenuItemId(), itemRequest.getQuantity());
        OrderItemResponse itemResponse = new OrderItemResponse();
        itemResponse.setOrderId(orderId);
        itemResponse.setMenuItemId(itemRequest.getMenuItemId());
        itemResponse.setQuantity(itemRequest.getQuantity());
        return ResponseEntity.status(HttpStatus.CREATED).body(itemResponse);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponse>> getCustomerOrders(@PathVariable Integer customerId) {
        User customer = userService.getUserById(customerId);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        List<OrderResponse> orders = orderService.getCustomerOrders(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Integer id) {
        OrderResponse order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponse> updateOrder(
            @PathVariable Integer orderId,
            @RequestBody UpdateOrderRequest updateRequest) {
        OrderResponse updatedOrder = orderService.updateOrder(orderId, updateRequest);
        return ResponseEntity.ok(updatedOrder);
    }
}
