package com.FinancialTransactionSys.FinancialTransactionSys.model;

import com.FinancialTransactionSys.FinancialTransactionSys.validator.Cnpj;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Cnpj
    @Column(unique = true)
    private String cnpj;

    private double saldo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Taxa> taxas = new ArrayList<>();

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Taxa> getTaxas() {
        return taxas;
    }

    public void setTaxas(List<Taxa> taxas) {
        this.taxas = taxas;
    }
}


