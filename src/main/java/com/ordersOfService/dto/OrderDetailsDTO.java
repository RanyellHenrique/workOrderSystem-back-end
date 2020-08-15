package com.ordersOfService.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ordersOfService.domain.Order;
import com.ordersOfService.domain.Payment;

public class OrderDetailsDTO extends OrderDTO {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDTO responsible;
	private ClientDTO client;
	private Payment payment;
	private List<OrderItemDTO> orderItems = new ArrayList<OrderItemDTO>();
	
	public OrderDetailsDTO(Order obj) {
		super(obj);
		this.responsible = new EmployeeDTO(obj.getResponsible());
		this.client = new ClientDTO(obj.getClient());
		this.payment = obj.getPayment();
		this.orderItems = obj.getOrderItems().stream().map(p -> new OrderItemDTO(p)).collect(Collectors.toList());
	}

	public EmployeeDTO getResponsible() {
		return responsible;
	}

	public void setResponsible(EmployeeDTO responsible) {
		this.responsible = responsible;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

	
}
