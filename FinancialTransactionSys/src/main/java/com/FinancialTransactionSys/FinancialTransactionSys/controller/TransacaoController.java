package com.FinancialTransactionSys.FinancialTransactionSys.controller;

import com.FinancialTransactionSys.FinancialTransactionSys.dto.TransacaoRequestDTO;
import com.FinancialTransactionSys.FinancialTransactionSys.model.Cliente;
import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import com.FinancialTransactionSys.FinancialTransactionSys.service.ClienteService;
import com.FinancialTransactionSys.FinancialTransactionSys.service.EmpresaService;
import com.FinancialTransactionSys.FinancialTransactionSys.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final ClienteService clienteService;
    private final EmpresaService empresaService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService, ClienteService clienteService, EmpresaService empresaService) {
        this.transacaoService = transacaoService;
        this.clienteService = clienteService;
        this.empresaService = empresaService;
    }

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarTransacao(@RequestBody TransacaoRequestDTO transacaoRequest) {
        // Busca o cliente pelo ID fornecido no DTO
        Cliente cliente = clienteService.getClienteById(transacaoRequest.getClienteId());
        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente não encontrado.");
        }

        // Busca a empresa pelo ID fornecido no DTO
        Empresa empresa = empresaService.getEmpresaById(transacaoRequest.getEmpresaId());
        if (empresa == null) {
            return ResponseEntity.badRequest().body("Empresa não encontrada.");
        }

        // Chama o serviço de transação para realizar a operação
        transacaoService.realizarTransacaoComTaxa(cliente, empresa, transacaoRequest.getValor());

        return ResponseEntity.ok("Transação realizada com sucesso.");
    }
}
