package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
