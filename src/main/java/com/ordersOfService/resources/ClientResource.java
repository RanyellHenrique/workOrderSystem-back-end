package com.ordersOfService.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersOfService.Services.ClientService;
import com.ordersOfService.domain.Client;
import com.ordersOfService.dto.ClientDTO;
import com.ordersOfService.dto.ClientDetailsDTO;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> list = service.findAll();
		List<ClientDTO> listDTO = list.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDetailsDTO> findById(@PathVariable Integer id){
		Client obj = service.findById(id);
		ClientDetailsDTO objDTO = new ClientDetailsDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

}
