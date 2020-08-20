package com.ordersOfService.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Category;
import com.ordersOfService.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Page<Product> findDistinctByNameContainingAndCategoriesIn( String nome, List<Category> categorias, Pageable pageRequest);
	

}
