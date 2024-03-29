package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByDescriptionContaining(String description, Pageable pageable);
}
