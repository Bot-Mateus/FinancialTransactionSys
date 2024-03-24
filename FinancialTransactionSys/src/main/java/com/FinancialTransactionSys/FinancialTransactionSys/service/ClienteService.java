package com.FinancialTransactionSys.FinancialTransactionSys.service;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Cliente;
import com.FinancialTransactionSys.FinancialTransactionSys.model.Transacao;
import com.FinancialTransactionSys.FinancialTransactionSys.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Transactional
    public void realizarTransacao(Cliente cliente, Transacao transacao) {
        // Verifica se o cliente tem saldo suficiente para a transação
        if (cliente.getSaldo() >= transacao.getValor()) {
            // Deduz o valor da transação do saldo do cliente
            double novoSaldo = cliente.getSaldo() - transacao.getValor();
            cliente.setSaldo(novoSaldo);
            clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Saldo insuficiente para realizar a transação");
        }
    }
}
