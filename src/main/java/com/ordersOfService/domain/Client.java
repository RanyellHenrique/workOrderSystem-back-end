package com.ordersOfService.domain;

import javax.persistence.Entity;

@Entity
public class Client  extends Person{
	private static final long serialVersionUID = 1L;
	
	private String cpfCnpj;
	
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
	
	

}
