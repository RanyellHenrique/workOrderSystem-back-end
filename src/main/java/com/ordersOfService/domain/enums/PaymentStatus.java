package com.ordersOfService.domain.enums;

public enum PaymentStatus {
	
	PEDING(1, "Peding"),
	CANCELED(2, "Canceled"),
	SETTLED(3, "Settled");

	private int cod;
	private String description;

	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription () {
		return description;
	}

	public static PaymentStatus toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (PaymentStatus x : PaymentStatus.values()) {
			if (cod.equals(x.getCod())) 
				return x;
		}
		throw new IllegalArgumentException("Id Invalid: " + cod);
	}

}
