package com.ordersOfService.dto;

import com.ordersOfService.domain.Client;

public class ClientDetailsDTO extends ClientDTO {
	private static final long serialVersionUID = 1L;
	
	private AddressDTO address;
	
	public ClientDetailsDTO() {
		
	}
	
	public ClientDetailsDTO(Client obj) {
		super(obj);
		this.address = new AddressDTO(obj.getAddress());
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

}
