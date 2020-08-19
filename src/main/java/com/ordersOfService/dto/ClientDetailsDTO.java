package com.ordersOfService.dto;

import java.util.HashSet;
import java.util.Set;

import com.ordersOfService.domain.Client;

public class ClientDetailsDTO extends ClientDTO {
	private static final long serialVersionUID = 1L;
	
	private AddressDTO address;
	private Set<String> phones = new HashSet<String>();
	
	public ClientDetailsDTO() {
		
	}
	
	public ClientDetailsDTO(Client obj) {
		super(obj);
		this.address = new AddressDTO(obj.getAddress());
		this.phones = obj.getPhones();
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

}
