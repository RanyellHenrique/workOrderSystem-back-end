package com.ordersOfService.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Employee extends Person {
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String cpf;
	
	@OneToMany(mappedBy="responsible")
	private List<Order> orders = new ArrayList<Order>();
	
	public Employee() {
		
	}

	public Employee(Integer id, String name, String email, String cpf, String password) {
		super(id, name, email);
		this.password = password;
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
