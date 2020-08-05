package com.ordersOfService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersOfService.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
