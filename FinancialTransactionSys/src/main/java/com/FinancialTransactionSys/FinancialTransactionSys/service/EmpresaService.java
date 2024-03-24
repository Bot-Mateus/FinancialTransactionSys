package com.FinancialTransactionSys.FinancialTransactionSys.service;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import com.FinancialTransactionSys.FinancialTransactionSys.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa criarEmpresa(Empresa empresa) {
        // Lógica para criar uma nova empresa
        return empresaRepository.save(empresa);
    }

    public Empresa obterEmpresaPorId(Long id) {
        // Lógica para obter uma empresa por ID
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa atualizarEmpresa(Long id, Empresa empresaAtualizada) {
        // Lógica para atualizar uma empresa
        Empresa empresaExistente = empresaRepository.findById(id).orElse(null);
        if (empresaExistente != null) {
            // Atualiza os atributos da empresaExistente com base nos da empresaAtualizada
            empresaExistente.setCnpj(empresaAtualizada.getCnpj());
            empresaExistente.setSaldo(empresaAtualizada.getSaldo());
            // Outros atributos...
            return empresaRepository.save(empresaExistente);
        } else {
            return null;
        }
    }

    public void deletarEmpresa(Long id) {
        // Lógica para deletar uma empresa
        empresaRepository.deleteById(id);
    }

    public void processarTransacaoComTaxa(Empresa empresa, double valorTransacao) {
        // Lógica para calcular a taxa da empresa e abater do saldo
        double taxa = calcularTaxa(empresa, valorTransacao);
        double saldoAtual = empresa.getSaldo();
        double novoSaldo = saldoAtual + valorTransacao - taxa;
        empresa.setSaldo(novoSaldo);
        empresaRepository.save(empresa);
    }

    private double calcularTaxa(Empresa empresa, double valorTransacao) {
        // Lógica para calcular a taxa da empresa com base no valor da transação
        // Este é um exemplo simples, substitua pela lógica real de cálculo da taxa
        return valorTransacao * 0.05; // Taxa de 5%
    }

    public Empresa getEmpresaById(Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        return empresaOptional.orElse(null);
    }

    // Outros métodos relacionados a operações de empresas
}
