package com.ordersOfService.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ordersOfService.domain.OrderItem;

public class OrderItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private ProductDTO product;
	private List<ProductUsedDTO> productsUsed = new ArrayList<ProductUsedDTO>();
	
	public OrderItemDTO() {
		
	}
	
	public OrderItemDTO(OrderItem obj) {
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.product = new ProductDTO(obj.getProduct());
		this.productsUsed = obj.getProductsUsed().stream().map(p -> new ProductUsedDTO(p)).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public List<ProductUsedDTO> getProductsUsed() {
		return productsUsed;
	}

	public void setProductsUsed(List<ProductUsedDTO> productsUsed) {
		this.productsUsed = productsUsed;
	}

}
