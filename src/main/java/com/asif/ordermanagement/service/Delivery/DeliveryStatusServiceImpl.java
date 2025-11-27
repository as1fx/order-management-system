package com.asif.ordermanagement.service.Delivery;

import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.DeliveryStatus;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.repository.DeliveryRepository;
import com.asif.ordermanagement.repository.DeliveryStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryStatusServiceImpl implements DeliveryStatusService{

    private final DeliveryStatusRepository deliveryStatusRepository;
    private final DeliveryRepository deliveryRepository;
    @Override
    public DeliveryStatus addStatus(DeliveryStatus status) {
        Delivery delivery = deliveryRepository.findByOrderId(status.getDelivery().getId())
                .orElseThrow(()-> new ResourceNotFoundException("Delivery Not Found" + status.getDelivery().getId()));
        status.setDelivery(delivery);
        return deliveryStatusRepository.save(status);
    }

    @Override
    public List<DeliveryStatus> getStatusesByDelivery(Integer deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(()-> new ResourceNotFoundException("Delivery Not Found" + deliveryId));
        return deliveryStatusRepository.findByDelivery(delivery);
    }
}
