package com.ordersOfService.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersOfService.Services.ProductService;
import com.ordersOfService.domain.Product;
import com.ordersOfService.dto.ProductDTO;
import com.ordersOfService.dto.ProductDetailsDTO;



@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		List<Product> list = service.findAll();
		List<ProductDTO> listDTO = list.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDetailsDTO> findById(@PathVariable Integer id){
		Product obj = service.findById(id);
		ProductDetailsDTO objDTO = new ProductDetailsDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

}
