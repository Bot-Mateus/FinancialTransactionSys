package com.FinancialTransactionSys.FinancialTransactionSys.service;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Cliente;
import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import com.FinancialTransactionSys.FinancialTransactionSys.validator.CpfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final EmpresaService empresaService;

    @Autowired
    public TransacaoService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public boolean realizarTransacaoComTaxa(Cliente cliente, Empresa empresa, double valorTransacao) {
        // Verifica se o CPF do cliente é válido
        if (!validarCpfCliente(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF do cliente inválido.");
        }

        // Lógica para realizar a transação
        // Aqui você pode adicionar outras validações, como verificar se o cliente tem saldo suficiente, etc.

        // Supondo que a transação é bem-sucedida, abate-se a taxa da empresa
        empresaService.processarTransacaoComTaxa(empresa, valorTransacao);

        // Retorna true para indicar que a transação foi realizada com sucesso
        return true;
    }

    private boolean validarCpfCliente(String cpf) {
        // Crie uma instância do CpfValidator
        CpfValidator cpfValidator = new CpfValidator();

        // Use o método isValid do CpfValidator para validar o CPF
        return cpfValidator.isValid(cpf, null);
    }
}

