package com.asif.ordermanagement.repository;

import com.asif.ordermanagement.entity.Delivery;
import com.asif.ordermanagement.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Integer> {

    List<DeliveryStatus> findByDelivery(Delivery delivery);
}
