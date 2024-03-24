package com.FinancialTransactionSys.FinancialTransactionSys;

import com.FinancialTransactionSys.FinancialTransactionSys.controller.TransacaoController;
import com.FinancialTransactionSys.FinancialTransactionSys.dto.TransacaoRequestDTO;
import com.FinancialTransactionSys.FinancialTransactionSys.model.Cliente;
import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import com.FinancialTransactionSys.FinancialTransactionSys.service.TransacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class TransacaoControllerTest {

    @Mock
    private TransacaoService transacaoService;

    @InjectMocks
    private TransacaoController transacaoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRealizarTransacao() {
        // Configurar dados de entrada para o teste
        TransacaoRequestDTO transacaoRequest = new TransacaoRequestDTO();
        transacaoRequest.setClienteId(1L);
        transacaoRequest.setEmpresaId(2L);
        transacaoRequest.setValor(100.0);

        // Criar objetos Cliente e Empresa válidos
        Cliente cliente = new Cliente();
        cliente.setId(1L); // Define o ID do cliente
        Empresa empresa = new Empresa();
        empresa.setId(2L); // Define o ID da empresa

        // Chamar o método a ser testado
        ResponseEntity<String> responseEntity = transacaoController.realizarTransacao(transacaoRequest);

        // Verificar se o serviço de transação foi chamado corretamente
        verify(transacaoService, times(1)).realizarTransacaoComTaxa(cliente, empresa, 100.0);
    }
}
