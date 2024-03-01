package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long> {
}
