package com.example.javadesignpattern.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// https://github.com/digitalinnovationone/lab-padroes-projeto-spring/blob/main/src/main/java/one/digitalinnovation/gof/model/Endereco.java

@Getter
@Setter
@Entity
public class Address {
    @Id
    private String cep;
    private int number;
    private String complement;


}
