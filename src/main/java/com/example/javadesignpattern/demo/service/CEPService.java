package com.example.javadesignpattern.demo.service;

import com.example.javadesignpattern.demo.model.Address;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface CEPService {

    @GetMapping("/{cep}/json/")
    static Address findCEP(@PathVariable("cep") String cep);
}
