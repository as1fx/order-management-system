package com.asif.ordermanagement.service.Delivery;

import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.DeliveryStatus;
import com.asif.ordermanagement.repository.DeliveryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeliveryStatusService {
    DeliveryStatus addStatus(DeliveryStatus status);
    List<DeliveryStatus> getStatusesByDelivery(Integer deliveryId);

}
