package com.ordersOfService.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToMany(mappedBy="id.product")
	private Set<ProductUsed> productsUsed = new HashSet<ProductUsed>();
	
	public OrderItem() {
		
	}

	public OrderItem(Integer id, String description, Product product, Order order) {
		super();
		this.id = id;
		this.description = description;
		this.product = product;
		this.order = order;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<ProductUsed> getProductsUsed() {
		return productsUsed;
	}

	public void setProductsUsed(Set<ProductUsed> productsUsed) {
		this.productsUsed = productsUsed;
	}

	
}
