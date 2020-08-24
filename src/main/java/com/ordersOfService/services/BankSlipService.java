package com.ordersOfService.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ordersOfService.domain.PaymentBySlip;

@Service
public class BankSlipService {
	
	public void fillPaymentWithBillet(PaymentBySlip pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDueDate(cal.getTime());
	}

}
