package com.ordersOfService.domain;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String cpf;
	
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

}
