package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalRepository extends JpaRepository<Local, Long> {
}
