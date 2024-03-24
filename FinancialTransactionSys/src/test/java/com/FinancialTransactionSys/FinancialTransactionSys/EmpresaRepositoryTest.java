package com.FinancialTransactionSys.FinancialTransactionSys;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import com.FinancialTransactionSys.FinancialTransactionSys.repository.EmpresaRepository;
import com.FinancialTransactionSys.FinancialTransactionSys.service.EmpresaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = "spring.config.location=src/test/resources/application-test.properties")
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Test
    public void testSalvarEmpresa() {
        // Criar uma empresa para teste
        Empresa empresa = new Empresa();
        empresa.setCnpj("12345678901234");
        empresa.setSaldo(1000.00);

        // Chamar o método de salvar empresa do repositório
        Empresa empresaSalva = empresaService.criarEmpresa(empresa);

        // Verificar se a empresa foi salva corretamente
        assertNotNull(empresaSalva);
        assertEquals("12345678901234", empresaSalva.getCnpj());
        assertEquals(1000.00, empresaSalva.getSaldo());
    }

    // Outros testes para os métodos de CRUD e consultas personalizadas, se necessário
}
