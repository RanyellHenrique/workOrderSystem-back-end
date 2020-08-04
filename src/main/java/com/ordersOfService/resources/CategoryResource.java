package com.ordersOfService.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersOfService.Services.CategoryService;
import com.ordersOfService.domain.Category;
import com.ordersOfService.dto.CategoryDTO;
import com.ordersOfService.dto.CategoryDetailsDTO;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<Category> list = service.findAll();
		List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDetailsDTO> findById(@PathVariable Integer id){
		Category obj = service.findById(id);
		CategoryDetailsDTO objDTO = new CategoryDetailsDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

}
