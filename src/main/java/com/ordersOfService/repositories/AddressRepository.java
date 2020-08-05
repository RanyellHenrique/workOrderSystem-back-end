package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
