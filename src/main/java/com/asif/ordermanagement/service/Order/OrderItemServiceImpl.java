package com.asif.ordermanagement.service.Order;

import com.asif.ordermanagement.entity.Order;
import com.asif.ordermanagement.entity.OrderItem;
import com.asif.ordermanagement.repository.OrderItemRepository;
import com.asif.ordermanagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService{

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    @Override
    public OrderItem createOrderItem(OrderItem item) {
        return orderItemRepository.save(item);
    }

    @Override
    public List<OrderItem> getItemsByOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not Found" + orderId));
        return orderItemRepository.findByOrder(order);
    }
}
