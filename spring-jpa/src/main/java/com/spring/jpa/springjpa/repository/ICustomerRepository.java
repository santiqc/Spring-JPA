package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String name);

    List<Customer> findByFirstNameContaining(String firstName);

    List<Customer> findByLastNameNotNull();
    List<Customer> findByAddress_City(String city);

    @Query("select c from Customer c where c.email = ?1")
    Customer getCustomerByEmailAddress(String email);
}
