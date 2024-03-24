package com.FinancialTransactionSys.FinancialTransactionSys.repository;

import java.util.List;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Método para buscar um cliente pelo CPF
    Cliente findByCpf(String cpf);

    // Método para buscar clientes por nome
    List<Cliente> findByNomeContainingIgnoreCase(String nome);


    // Método para deletar um cliente pelo CPF
    void deleteByCpf(String cpf);
}
