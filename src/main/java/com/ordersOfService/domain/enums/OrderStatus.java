package com.ordersOfService.domain.enums;

public enum OrderStatus {
	
	OPEN(1, "Open"),
	CLOSED(2, "Closed"),
	INPROGRESS(3, "In progress");

	private int cod;
	private String description;

	private OrderStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription () {
		return description;
	}

	public static OrderStatus toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (OrderStatus x : OrderStatus.values()) {
			if (cod.equals(x.getCod())) 
				return x;
		}
		throw new IllegalArgumentException("Id Invalid: " + cod);
	}

}
