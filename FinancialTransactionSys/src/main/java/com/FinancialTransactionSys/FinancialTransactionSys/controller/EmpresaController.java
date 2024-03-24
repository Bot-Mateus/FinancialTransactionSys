package com.FinancialTransactionSys.FinancialTransactionSys.controller;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import com.FinancialTransactionSys.FinancialTransactionSys.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaService.criarEmpresa(empresa);
        return new ResponseEntity<>(novaEmpresa, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = empresaService.obterEmpresaPorId(id);
        if (empresa != null) {
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa empresaAtualizada = empresaService.atualizarEmpresa(id, empresa);
        if (empresaAtualizada != null) {
            return new ResponseEntity<>(empresaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Outros métodos para operações relacionadas a empresas, como realizar transações, etc.
}

