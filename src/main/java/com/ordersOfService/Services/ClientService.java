package com.ordersOfService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersOfService.Services.exceptions.ObjectNotFoundException;
import com.ordersOfService.domain.Client;
import com.ordersOfService.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Not found, Id: " + id + ",type: " + Client.class.getName()));
	}

}
