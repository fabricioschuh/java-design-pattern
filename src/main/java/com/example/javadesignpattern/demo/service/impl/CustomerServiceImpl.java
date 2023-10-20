package com.example.javadesignpattern.demo.service.impl;

import com.example.javadesignpattern.demo.model.Address;
import com.example.javadesignpattern.demo.model.AddressRepository;
import com.example.javadesignpattern.demo.model.Customer;
import com.example.javadesignpattern.demo.model.CustomerRepository;
import com.example.javadesignpattern.demo.service.CEPService;
import com.example.javadesignpattern.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    // Singleton: inject components from Spring with @Autowired.
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CEPService cepService;


    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    @Override
    public void insert(Customer customer) {
        insert(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerBd = customerRepository.findById(id);
        if (customerBd.isPresent()) {
            saveCustomer(customer);
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private void saveCustomer(Customer customer) {
        String cep = customer.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = CEPService.findCEP(cep);
            AddressRepository.save(newAddress);
            return newAddress;
        });
        customer.setAddress(address);
        customerRepository.save(customer);
    }
}
