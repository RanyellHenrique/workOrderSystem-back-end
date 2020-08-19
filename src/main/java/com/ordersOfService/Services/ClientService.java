package com.ordersOfService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordersOfService.Services.exceptions.ObjectNotFoundException;
import com.ordersOfService.domain.Address;
import com.ordersOfService.domain.Client;
import com.ordersOfService.dto.ClientNewDTO;
import com.ordersOfService.repositories.AddressRepository;
import com.ordersOfService.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Not found, Id: " + id + ",type: " + Client.class.getName()));
	}
	
	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repository.save(obj);
		addressRepository.save(obj.getAddress());
		return obj;
	}
	
	public Client fromDTO(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfCnpj());
		Address address = new Address(null, objDto.getCep(), objDto.getState(), objDto.getCity(), objDto.getNeighborhood(), objDto.getStreet(), objDto.getComplement(), cli);
		cli.getPhones().add(objDto.getPhone());
		cli.setAddress(address);
		return cli;
	}

}
