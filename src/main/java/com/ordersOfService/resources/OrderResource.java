package com.ordersOfService.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersOfService.Services.OrderService;
import com.ordersOfService.domain.Order;
import com.ordersOfService.dto.OrderDTO;
import com.ordersOfService.dto.OrderDetailsDTO;
//import com.ordersOfService.dto.OrderDetailsDTO;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<Order> list = service.findAll();
		List<OrderDTO> listDTO = list.stream().map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDetailsDTO> findById(@PathVariable Integer id){
		Order obj = service.findById(id);
		OrderDetailsDTO objDTO = new OrderDetailsDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

}
