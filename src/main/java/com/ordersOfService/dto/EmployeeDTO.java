package com.ordersOfService.dto;

import java.io.Serializable;

import com.ordersOfService.domain.Employee;

public class EmployeeDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private String cpf;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(Employee obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
