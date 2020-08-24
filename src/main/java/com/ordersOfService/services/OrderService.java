package com.ordersOfService.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ordersOfService.domain.Order;
import com.ordersOfService.domain.OrderItem;
import com.ordersOfService.domain.PaymentBySlip;
import com.ordersOfService.domain.enums.PaymentStatus;
import com.ordersOfService.repositories.OrderItemRepository;
import com.ordersOfService.repositories.OrderRepository;
import com.ordersOfService.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BankSlipService bankSlipService;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Not found, Id: " + id + ",type: " + Order.class.getName()));
	}
	
	public Page<Order> search(String name, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findByClientNameContainingIgnoreCase(name, pageRequest);
	}
	
	public Page<Order> searchPerClient(Integer id, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findByClientId(id, pageRequest);
	}
	

 	public Order insert(Order obj) {
 		obj.setId(null);
		obj.setClient(clientService.findById(obj.getClient().getId()));
		obj.setInitialDate(new Date());
		obj.getPayment().setStatus(PaymentStatus.PEDING);
		obj.getPayment().setOrder(obj);
		if(obj.getPayment() instanceof PaymentBySlip) {
			PaymentBySlip paym = (PaymentBySlip) obj.getPayment();
			bankSlipService.fillPaymentWithBillet(paym, obj.getInitialDate());
		}
		obj = repository.save(obj);
		for(OrderItem e : obj.getOrderItems()) {
			e.setOrder(obj);
			orderItemRepository.save(e);
		}
		return obj;
		
	}


}
