package com.FinancialTransactionSys.FinancialTransactionSys.repository;

import com.FinancialTransactionSys.FinancialTransactionSys.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    Empresa findByCnpj(String cnpj);
}
