package org.jnosql.example.domain.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.jnosql.example.domain.Book;

public class IsbnValidator implements ConstraintValidator<ValidIsbn, Book> {
    @Override
    public boolean isValid(Book book, ConstraintValidatorContext context) {
        if (book == null) {
            return false;
        }

        String isbn = prepareIsbn(book.getIsbn());
        if (isbn.length() != 13) {
            return false;
        }

        int checkDigitResult = calculateCheckDigit(isbn);
        return toInt(isbn.charAt(12)) == checkDigitResult;
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
