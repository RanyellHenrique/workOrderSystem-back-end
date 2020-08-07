package com.ordersOfService.domain;

import javax.persistence.Entity;

import com.ordersOfService.domain.enums.PaymentStatus;

@Entity
public class PaymentByCard extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer plots;
	
	public PaymentByCard() {
		
	}

	public PaymentByCard(Integer id, PaymentStatus status, Integer plots, Order order) {
		super(id, status, order);
		this.plots = plots;
	}



	public Integer getPlots() {
		return plots;
	}

	public void setPlots(Integer plots) {
		this.plots = plots;
	}
	
	

}
