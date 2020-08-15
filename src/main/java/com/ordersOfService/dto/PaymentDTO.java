package com.ordersOfService.dto;

import java.io.Serializable;

import com.ordersOfService.domain.enums.PaymentStatus;

public  abstract class PaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer status;
	
	public PaymentDTO(Integer id, PaymentStatus status) {
		super();
		this.id = id;
		this.status = status.getCod();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(this.status);
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
}
