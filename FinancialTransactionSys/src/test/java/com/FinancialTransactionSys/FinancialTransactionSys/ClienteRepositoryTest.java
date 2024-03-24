package com.FinancialTransactionSys.FinancialTransactionSys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Cliente;
import com.FinancialTransactionSys.FinancialTransactionSys.repository.ClienteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSalvarCliente() {
        // Criar um cliente para teste
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678900");
        cliente.setNome("João");

        // Salvar o cliente usando o repositório
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Verificar se o cliente foi salvo corretamente
        assertNotNull(clienteSalvo.getId());
        assertEquals("12345678900", clienteSalvo.getCpf());
        assertEquals("João", clienteSalvo.getNome());
    }

    @Test
    public void testBuscarPorCpf() {
        // Criar um cliente de exemplo
        Cliente cliente = new Cliente();
        cliente.setCpf("98765432100");
        cliente.setNome("Maria");

        // Persistir o cliente no banco de dados usando o entityManager
        entityManager.persist(cliente);

        // Buscar o cliente pelo CPF usando o repositório
        Cliente clienteEncontrado = clienteRepository.findByCpf("98765432100");

        // Verificar se o cliente foi encontrado corretamente
        assertNotNull(clienteEncontrado);
        assertEquals("98765432100", clienteEncontrado.getCpf());
        assertEquals("Maria", clienteEncontrado.getNome());
    }

    // Adicione mais testes conforme necessário para outros métodos do repositório
}

