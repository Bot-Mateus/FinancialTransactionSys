package com.FinancialTransactionSys.FinancialTransactionSys;

import com.FinancialTransactionSys.FinancialTransactionSys.validator.CpfValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpfValidatorTest {

    private final CpfValidator validator = new CpfValidator();

    @Test
    public void testValidCpf() {
        assertTrue(validator.isValid("123.456.789-09", null));
        assertTrue(validator.isValid("529.982.247-25", null));
    }

    @Test
    public void testInvalidCpf() {
        assertFalse(validator.isValid(null, null));
        assertFalse(validator.isValid("", null));
        assertFalse(validator.isValid("123.456.789-10", null));
        assertFalse(validator.isValid("000.000.000-00", null));
        assertFalse(validator.isValid("111.111.111-11", null));
    }
}
