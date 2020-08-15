package com.ordersOfService.dto;

import java.io.Serializable;

import com.ordersOfService.domain.ProductUsed;

public class ProductUsedDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer quantity;
	private Double price;
	private ProductDTO product;

	public ProductUsedDTO() {
		
	}
	
	public ProductUsedDTO(ProductUsed obj) {
		this.quantity = obj.getQuantity();
		this.price = obj.getPrice();
		this.product = new ProductDTO(obj.getProduct());
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
