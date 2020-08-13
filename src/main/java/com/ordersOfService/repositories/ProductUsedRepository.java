package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.ProductUsed;

public interface ProductUsedRepository extends JpaRepository<ProductUsed, Integer> {

}
