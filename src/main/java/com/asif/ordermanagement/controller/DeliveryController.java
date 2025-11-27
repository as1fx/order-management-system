package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.Delivery.DeliveryRequest;
import com.asif.ordermanagement.dto.Delivery.DeliveryResponse;
import com.asif.ordermanagement.service.Delivery.DeliveryService;
import com.asif.ordermanagement.service.Delivery.DeliveryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryServiceImpl deliveryService;

    @PostMapping("/assign")
    public ResponseEntity<DeliveryResponse> assignDelivery(@RequestBody DeliveryRequest request) {
        DeliveryResponse response = deliveryService.assignDelivery(request.getOrderId(), request.getDeliveryPartnerId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<DeliveryResponse> getDeliveryByOrder(@PathVariable Integer orderId) {
        DeliveryResponse delivery = deliveryService.getDeliveryByOrder(orderId);
        return ResponseEntity.ok(delivery);
    }
}
