package com.ordersOfService.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ordersOfService.domain.Category;

public class CategoryDetailsDTO extends CategoryDTO{
	private static final long serialVersionUID = 1L;
	
	private List<ProductDTO> products = new ArrayList<ProductDTO>();
	
	public CategoryDetailsDTO() {
		
	}

	public CategoryDetailsDTO(Category obj) {
		super(obj);
		this.products = obj.getProducts().stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	

}
