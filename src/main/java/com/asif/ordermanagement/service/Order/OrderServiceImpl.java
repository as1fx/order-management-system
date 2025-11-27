package com.asif.ordermanagement.service.Order;

import com.asif.ordermanagement.dto.Order.OrderRequest;
import com.asif.ordermanagement.dto.Order.OrderResponse;
import com.asif.ordermanagement.dto.Order.UpdateOrderRequest;
import com.asif.ordermanagement.entity.*;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.mapper.Order.OrderMapper;
import com.asif.ordermanagement.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final UserRepository userRepository;
    private final OrderRepository  orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;


    @Override
    public OrderResponse createOrder(OrderRequest request) {
        User customer = userRepository.findById(request.getCustomerId())
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found" + request.getCustomerId()));
        Restaurant  restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(()-> new ResourceNotFoundException("Restaurant not found" + request.getRestaurantId()));

        Order order = new Order();
        order.setCustomer(customer);
        order.setRestaurant(restaurant);
        order.setTotalAmount(java.math.BigDecimal.ZERO);

        orderRepository.save(order);

        return OrderMapper.toOrderResponse(order);
    }

    @Override
    public OrderResponse addItem(Integer orderId, Integer menuItemId, Integer quantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found" + orderId));
        MenuItem item = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item Not Found" + menuItemId));

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setMenuItem(item);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(item.getPrice().multiply(java.math.BigDecimal.valueOf(quantity)));

        orderItemRepository.save(orderItem);

        return OrderMapper.toOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getCustomerOrders(Integer customerId) {
        return orderRepository.findById(customerId).stream()
                .map(OrderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Order Not Found" + id));

        return OrderMapper.toOrderResponse(order);
    }

    @Override
    public OrderResponse updateOrder(Integer orderId, UpdateOrderRequest request) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found" + orderId));

        if(request.getOrderStatus() != null){
            order.setStatus(Enum.valueOf(Order.OrderStatus.class, request.getOrderStatus()));
        }
        if(request.getPaymentStatus() != null){
            order.setPaymentStatus(Enum.valueOf(Order.PaymentStatus.class, request.getPaymentStatus()));
        }
        orderRepository.save(order);
        return OrderMapper.toOrderResponse(order);
    }
}
