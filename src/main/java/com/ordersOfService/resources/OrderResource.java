package com.ordersOfService.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ordersOfService.domain.Order;
import com.ordersOfService.dto.OrderDTO;
import com.ordersOfService.dto.OrderDetailsDTO;
import com.ordersOfService.services.OrderService;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDetailsDTO> findById(@PathVariable Integer id){
		Order obj = service.findById(id);
		OrderDetailsDTO objDTO = new OrderDetailsDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<OrderDTO>> findPage(
			@RequestParam(value="name", defaultValue="") String name, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="initialDate") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Order> list = service.search(name, page, linesPerPage, orderBy, direction);
		Page<OrderDTO> listDto = list.map(obj -> new OrderDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/client/{id}")
	public ResponseEntity<Page<OrderDTO>> findPagePerClient(
			@PathVariable Integer id, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="initialDate") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Order> list = service.searchPerClient(id, page, linesPerPage, orderBy, direction);
		Page<OrderDTO> listDto = list.map(obj -> new OrderDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Order obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
