package com.ordersOfService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersOfService.domain.Category;
import com.ordersOfService.dto.CategoryDTO;
import com.ordersOfService.repositories.CategoryRepository;
import com.ordersOfService.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Not found, Id: " + id + ",type: " + Category.class.getName()));
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Category update(Category obj) {
		Category newObj = repository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void updateData(Category newObj, Category obj) {
		newObj.setName(obj.getName());
	}
	
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}
}
