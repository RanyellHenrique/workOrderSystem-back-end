package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
