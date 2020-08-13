package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
