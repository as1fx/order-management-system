package com.asif.ordermanagement.mapper.Delivery;

import com.asif.ordermanagement.dto.Delivery.DeliveryResponse;
import com.asif.ordermanagement.dto.DeliveryStatus.DeliveryStatusResponse;
import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.DeliveryStatus;

public class DeliveryMapper {
    public static DeliveryResponse toDeliveryResponse(Delivery delivery) {
        DeliveryResponse response = new DeliveryResponse();
        response.setId(delivery.getId());
        response.setOrderId(delivery.getOrder().getId());
        response.setDeliveryPartnerId(delivery.getDeliveryPartner().getId());
        response.setAssignedAt(delivery.getTimestamp().toString());

        return response;
    }

    public static DeliveryStatusResponse toStatusResponse(DeliveryStatus deliveryStatus) {
        DeliveryStatusResponse response = new DeliveryStatusResponse();
        response.setId(deliveryStatus.getId());
        response.setDeliveryId(deliveryStatus.getDelivery().getId());
        response.setStatus(deliveryStatus.getStatus().name());
        response.setUpdatedAt(deliveryStatus.getUpdatedAt().toString());

        return response;
    }
}
