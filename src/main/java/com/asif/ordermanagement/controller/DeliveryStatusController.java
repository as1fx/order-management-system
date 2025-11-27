package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.DeliveryStatus.DeliveryStatusRequest;
import com.asif.ordermanagement.dto.DeliveryStatus.DeliveryStatusResponse;
import com.asif.ordermanagement.entity.DeliveryStatus;
import com.asif.ordermanagement.service.Delivery.DeliveryStatusService;
import com.asif.ordermanagement.service.Delivery.DeliveryStatusServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/delivery/status")
@RequiredArgsConstructor
public class DeliveryStatusController {

    private final DeliveryStatusServiceImpl deliveryStatusService;

    @PostMapping
    public ResponseEntity<DeliveryStatusResponse> updateStatus(@RequestBody DeliveryStatusRequest request) {
        DeliveryStatus status = new DeliveryStatus();
        status.setDelivery(null);
        status.setStatus(DeliveryStatus.DeliveryState.valueOf(request.getStatus().toUpperCase()));
        status.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        DeliveryStatus savedStatus = deliveryStatusService.addStatus(status);

        DeliveryStatusResponse response = new DeliveryStatusResponse();
        response.setId(savedStatus.getId());
        response.setDeliveryId(savedStatus.getDelivery().getId());
        response.setStatus(savedStatus.getStatus().name());
        response.setUpdatedAt(savedStatus.getUpdatedAt().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<List<DeliveryStatusResponse>> getDeliveryStatus(@PathVariable Integer deliveryId) {
        List<DeliveryStatus> statuses = deliveryStatusService.getStatusesByDelivery(deliveryId);
        List<DeliveryStatusResponse> responses = statuses.stream().map(status -> {
            DeliveryStatusResponse response = new DeliveryStatusResponse();
            response.setId(status.getId());
            response.setDeliveryId(status.getDelivery().getId());
            response.setStatus(status.getStatus().name());
            response.setUpdatedAt(status.getUpdatedAt().toString());
            return response;
        }).toList();
        return ResponseEntity.ok(responses);
    }
}
