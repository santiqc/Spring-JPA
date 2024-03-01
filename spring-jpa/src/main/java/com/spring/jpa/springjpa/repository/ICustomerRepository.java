package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
