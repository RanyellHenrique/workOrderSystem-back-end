package com.ordersOfService.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.ordersOfService.domain.enums.PaymentStatus;

@Entity
public class PaymentBySlip extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date payDay;
	
	public PaymentBySlip() {
		
	}

	public PaymentBySlip(Integer id, PaymentStatus status, Order order, Date dueDate, Date payDay) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payDay = payDay;
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
