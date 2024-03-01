package com.spring.jpa.springjpa.repository;

import com.spring.jpa.springjpa.entity.Local;
import com.spring.jpa.springjpa.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IManagerRepositoryTest {

    @Autowired
    private IManagerRepository managerRepository;

    @Test
    public void findAllManagers(){
        List<Manager> managerList = managerRepository.findAll();
        System.out.println("managerList = " + managerList);
    }


}