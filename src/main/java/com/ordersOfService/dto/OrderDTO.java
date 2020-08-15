package com.ordersOfService.dto;

import java.io.Serializable;
import java.util.Date;

import com.ordersOfService.domain.Order;
import com.ordersOfService.domain.enums.OrderStatus;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date initialDate;
	private Date finalDate;
	private Integer status;
	
	public OrderDTO(Order obj) {
		this.id = obj.getId();
		this.initialDate = obj.getInitialDate();
		this.finalDate = obj.getFinalDate();
		this.status = obj.getStatus().getCod();
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public OrderStatus getStatus() {
		return OrderStatus.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

}
