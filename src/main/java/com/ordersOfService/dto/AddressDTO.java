package com.ordersOfService.dto;

import java.io.Serializable;

import com.ordersOfService.domain.Address;

public class AddressDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cep;
	private String state;
	private String city;
	private String neighborhood;
	private String Street;
	private String complement;
	
	public AddressDTO() {
		
	}
	
	public AddressDTO(Address obj) {
		this.id = obj.getId();
		this.cep = obj.getCep();
		this.state = obj.getState();
		this.city = obj.getCity();
		this.neighborhood = obj.getNeighborhood();
		this.Street = obj.getStreet();
		this.complement = obj.getComplement();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
}
