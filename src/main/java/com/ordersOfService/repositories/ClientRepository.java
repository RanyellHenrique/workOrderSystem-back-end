package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
