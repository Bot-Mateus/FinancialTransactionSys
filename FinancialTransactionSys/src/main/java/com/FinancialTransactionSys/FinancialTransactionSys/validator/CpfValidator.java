package com.FinancialTransactionSys.FinancialTransactionSys.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.regex.Pattern;

public class CpfValidator implements ConstraintValidator<Cpf, String> {

    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    @Override
    public void initialize(Cpf constraintAnnotation) {
        // Método necessário pela interface ConstraintValidator
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            return false; // Formato inválido
        }

        // Remover caracteres não numéricos
        String cpfNumerico = cpf.replaceAll("[^\\d]", "");

        // Verificar se todos os dígitos são iguais, o que é inválido
        if (cpfNumerico.chars().allMatch(digit -> digit == cpfNumerico.charAt(0))) {
            return false;
        }

        // Calcula os dígitos verificadores
        int length = cpfNumerico.length();
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(cpfNumerico.charAt(i));
        }
        int dv1 = calculateDigit(digits, 9);
        int dv2 = calculateDigit(digits, 10);

        // Verifica se os dígitos verificadores calculados são iguais aos informados
        return digits[9] == dv1 && digits[10] == dv2;
    }

    private int calculateDigit(int[] digits, int position) {
        int sum = 0;
        int weight = position + 1;
        for (int i = 0; i < position; i++) {
            sum += digits[i] * weight--;
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}



