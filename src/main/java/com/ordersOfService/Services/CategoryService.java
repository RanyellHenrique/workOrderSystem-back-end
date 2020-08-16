package com.ordersOfService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersOfService.Services.exceptions.ObjectNotFoundException;
import com.ordersOfService.domain.Category;
import com.ordersOfService.dto.CategoryDTO;
import com.ordersOfService.repositories.CategoryRepository;

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
		System.out.println(obj.getName());
		return repository.save(obj);
	}
	
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}

}
