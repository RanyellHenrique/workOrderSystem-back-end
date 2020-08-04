package com.ordersOfService.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ordersOfService.domain.Product;

public class ProductDetailsDTO extends ProductDTO {
	private static final long serialVersionUID = 1L;

	private List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
	
	public ProductDetailsDTO(Product obj) {
		super(obj);
		this.categories = obj.getCategories().stream().map(p -> new CategoryDTO(p)).collect(Collectors.toList());
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
	
}
