package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
