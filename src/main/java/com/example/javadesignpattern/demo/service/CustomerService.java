package com.example.javadesignpattern.demo.service;

import com.example.javadesignpattern.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(Long id);

    void insert(Customer customer);

    void update(Long id, Customer customer);

    void delete(Long id);
}

