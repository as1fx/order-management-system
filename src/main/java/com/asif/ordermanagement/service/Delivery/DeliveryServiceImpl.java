package com.asif.ordermanagement.service.Delivery;

import com.asif.ordermanagement.dto.Delivery.DeliveryResponse;
import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.User;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.mapper.Delivery.DeliveryMapper;
import com.asif.ordermanagement.repository.DeliveryRepository;
import com.asif.ordermanagement.repository.OrderRepository;
import com.asif.ordermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{

    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;
    private final UserRepository userRepository;
    @Override
    public DeliveryResponse assignDelivery(Integer orderId, Integer partnerId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found" + orderId));
        User partner = userRepository.findById(partnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Partner Not Found" + partnerId));

        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDeliveryPartner(partner);

        deliveryRepository.save(delivery);

        return DeliveryMapper.toDeliveryResponse(delivery);
    }

    @Override
    public DeliveryResponse getDeliveryByOrder(Integer orderId) {
        Delivery delivery = deliveryRepository.findByOrderId(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Not Found for Order" + orderId));
        return DeliveryMapper.toDeliveryResponse(delivery);
    }
}
