package com.ordersOfService.dto;

import com.ordersOfService.domain.PaymentByCard;

public class PaymentByCardDTO extends PaymentDTO {
	private static final long serialVersionUID = 1L;
	
	private Integer plots;

	public PaymentByCardDTO(PaymentByCard obj) {
		super(obj.getId(), obj.getStatus());
		this.plots = obj.getPlots();
	}

	public Integer getPlots() {
		return plots;
	}

	public void setPlots(Integer plots) {
		this.plots = plots;
	}
}
