package com.asif.ordermanagement.service.Delivery;

import com.asif.ordermanagement.dto.Delivery.DeliveryResponse;
import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface DeliveryService {
    DeliveryResponse assignDelivery(Integer orderId, Integer partnerId);
    DeliveryResponse getDeliveryByOrder(Integer orderId);

}
