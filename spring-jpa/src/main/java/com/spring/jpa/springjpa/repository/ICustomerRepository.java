package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String name);

    List<Customer> findByFirstNameContaining(String firstName);

    List<Customer> findByLastNameNotNull();

    List<Customer> findByAddress_City(String city);

    @Query("select c from Customer c where c.email = ?1")
    Customer getCustomerByEmailAddress(String email);

    @Query("select c.firstName from Customer c where c.email = ?1")
    String getCustomerFirstNameByEmailAddress(String email);

    @Query(
            value = "select * from tbl_customer where email_address = ?1",
            nativeQuery = true
    )
    Customer getCustomerByEmailAddressNative(String email);

    @Query(
            value = "select * from tbl_customer where email_address = :emailAddress",
            nativeQuery = true
    )
    Customer getCustomerByEmailAddressNativeNamedParam(@Param("emailAddress") String email);


    @Transactional
    @Modifying
    @Query(
            value = "update tbl_customer set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    void updateCustomerNameByEmail(String name, String email);
}
