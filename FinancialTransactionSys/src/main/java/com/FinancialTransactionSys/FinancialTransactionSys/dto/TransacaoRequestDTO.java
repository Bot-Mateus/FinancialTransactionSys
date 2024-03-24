package com.FinancialTransactionSys.FinancialTransactionSys.dto;

public class TransacaoRequestDTO {
    private Long clienteId;
    private Long empresaId;
    private Double valor;

    // getters e setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
