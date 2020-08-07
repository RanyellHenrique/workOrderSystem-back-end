package com.ordersOfService.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client  extends Person{
	private static final long serialVersionUID = 1L;
	
	private String cpfCnpj;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="client")
	private Address address;
	
	@OneToMany(mappedBy="client")
	private List<Order> orders = new ArrayList<Order>();

	public Client() {
		
	}

	public Client(Integer id, String name, String email, String cpfCnpj) {
		super(id, name, email);
		this.cpfCnpj = cpfCnpj;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
