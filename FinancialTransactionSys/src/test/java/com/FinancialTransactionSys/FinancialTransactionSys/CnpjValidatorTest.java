package com.FinancialTransactionSys.FinancialTransactionSys;

import com.FinancialTransactionSys.FinancialTransactionSys.validator.CnpjValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CnpjValidatorTest {

    private final CnpjValidator validator = new CnpjValidator();

    @Test
    public void testValidCnpj() {
        assertTrue(validator.isValid("20.560.010/4031-91", null));

    }

    @Test
    public void testInvalidCnpj() {
        assertFalse(validator.isValid("11.111.111/1111-11", null));
        assertFalse(validator.isValid("22.222.222/2222-22", null));
    }
}