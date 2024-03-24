package com.FinancialTransactionSys.FinancialTransactionSys.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CnpjValidator implements ConstraintValidator<Cnpj, String> {

    private static final Pattern CNPJ_PATTERN = Pattern.compile(
            "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");

    @Override
    public void initialize(Cnpj constraintAnnotation) {
        // Método necessário pela interface ConstraintValidator
    }

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {
        if (cnpj == null || !CNPJ_PATTERN.matcher(cnpj).matches()) {
            return false; // Formato inválido
        }

        // Remover caracteres não numéricos
        String cnpjNumerico = cnpj.replaceAll("\\D", "");

        // Verificar se todos os dígitos são iguais, o que é inválido
        return !cnpjNumerico.chars().allMatch(digit -> digit == cnpjNumerico.charAt(0));
    }
}
