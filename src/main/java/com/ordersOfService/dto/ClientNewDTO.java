package com.ordersOfService.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClientNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Name is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String name;
	
	@Email(message = "Email not is valid")
	private String email;
	
	@NotEmpty(message = "Cpf not is valid")
	private String cpfCnpj;
	
	@NotEmpty(message = "Cep is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String cep;
	
	@NotEmpty(message = "State is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String state;
	
	@NotEmpty(message = "City is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String city;
	
	@NotEmpty(message = "Neighborhood is mandatory")
	@Length(max = 80, min = 1, message = "The length must be between 5 and 120 characters")
	private String neighborhood;
	
	@NotEmpty(message = "Street is mandatory")
	@Length(max = 80, min = 1, message = "The length must be between 5 and 120 characters")
	private String street;
	
	private String complement;
	
	@NotEmpty(message = "Neighborhood is mandatory")
	@Length(max = 80, min = 3, message = "The length must be between 5 and 120 characters")
	private String phone;
	
	public ClientNewDTO() {
		
	}

	public ClientNewDTO(String name, String email, String cpfCnpj, String cep, String state, String city,
			String neighborhood, String street, String complement, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.cep = cep;
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.complement = complement;
		this.phone = phone;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
