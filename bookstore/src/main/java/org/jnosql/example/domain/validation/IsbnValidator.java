package org.jnosql.example.domain.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsbnValidator implements ConstraintValidator<ValidIsbn, String> {
    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext context) {
        if (isbn == null) {
            return false;
        }

        String cleanedIsbn = prepareIsbn(isbn);
        if (cleanedIsbn.length() != 13) {
            return false;
        }

        int checkDigitResult = calculateCheckDigit(cleanedIsbn);
        return toInt(cleanedIsbn.charAt(12)) == checkDigitResult;
    }

    private String prepareIsbn(String isbn) {
        return isbn.replace("-", "");
    }

    private int calculateCheckDigit(String isbn) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (1 + i % 2 * 2) * toInt(isbn.charAt(i));
        }
        return 10 - sum % 10;
    }

    private static int toInt(char ch) {
        return Character.getNumericValue(ch);
    }
}
