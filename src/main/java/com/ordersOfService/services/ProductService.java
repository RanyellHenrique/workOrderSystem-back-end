package com.ordersOfService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ordersOfService.domain.Category;
import com.ordersOfService.domain.Product;
import com.ordersOfService.repositories.CategoryRepository;
import com.ordersOfService.repositories.ProductRepository;
import com.ordersOfService.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Not found, Id: " + id + ",type: " + Product.class.getName()));
	}
	
	public Page<Product> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = categoryRepository.findAllById(ids);
		return repository.findDistinctByNameContainingAndCategoriesIn(nome, categories, pageRequest);	
	}
	
	public Product insert(Product obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Product update(Product obj) {
		return repository.save(obj);
	}

}
