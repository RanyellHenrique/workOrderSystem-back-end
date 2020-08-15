package com.ordersOfService.dto;

import java.util.Date;

import com.ordersOfService.domain.PaymentBySlip;

public class PaymentBySlipDTO  extends PaymentDTO{
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date payDay;

	public PaymentBySlipDTO(PaymentBySlip obj) {
		super(obj.getId(), obj.getStatus());
		this.dueDate = obj.getDueDate();
		this.payDay = obj.getPayDay();
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}
	
}
