package com.ordersOfService.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.ordersOfService.domain.pk.ProductUsedPK;

@Entity
public class ProductUsed implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProductUsedPK id = new ProductUsedPK();
	private Integer quantity;
	private Double price;
	
	public ProductUsed() {
		
	}

	public ProductUsed(Integer quantity, Double price, Product product, OrderItem orderItem) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.id.setProduct(product);
		this.id.setOrderItem(orderItem);
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
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public OrderItem getOrderItem() {
		return id.getOrderItem();
	}
	
	public void setOrderItem(OrderItem orderItem) {
		id.setOrderItem(orderItem);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductUsed other = (ProductUsed) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
