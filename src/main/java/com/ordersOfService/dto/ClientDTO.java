package com.ordersOfService.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ordersOfService.domain.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Name is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String name;
	
	@NotEmpty(message = "Email is mandatory")
	@Email(message = "Email invalid")
	private String email;
	
	@NotEmpty(message = "Cpf ou Cnpj is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String cpfCnpj;
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Client obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.cpfCnpj = obj.getCpfCnpj();
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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

}
