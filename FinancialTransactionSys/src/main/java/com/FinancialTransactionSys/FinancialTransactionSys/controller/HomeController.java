package com.FinancialTransactionSys.FinancialTransactionSys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Retorna o nome da página HTML
    }

    @GetMapping("/clients/new")
    public String showCreateClientForm() {
        return "create-client"; // Retorna o nome da página HTML para criar clientes
    }

    @GetMapping("/companies/new")
    public String companies() {
        return "create-companies"; // Retorne o nome da página de empresas
    }

    @GetMapping("/transaction/new")
    public String transactions() {
        return "transacao"; // Retorne o nome da página de transações
    }
}