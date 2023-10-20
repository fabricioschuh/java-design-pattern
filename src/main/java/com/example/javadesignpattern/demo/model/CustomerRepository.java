package com.example.javadesignpattern.demo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends CrudRepository<Customer, Long> {
}
