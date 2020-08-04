package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
