package com.ordersOfService.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Page<Order> findByClientId(Integer clientId, Pageable pageRequest);
	
	Page<Order> findByClientNameContainingIgnoreCase(String name, Pageable pageRequest);
}
