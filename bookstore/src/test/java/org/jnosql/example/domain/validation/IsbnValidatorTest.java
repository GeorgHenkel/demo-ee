package org.jnosql.example.domain.validation;

import org.jnosql.example.domain.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsbnValidatorTest {
    private final IsbnValidator validator = new IsbnValidator();

    @Test
    public void validateIsbnTrue() {
        var book = new Book();
        book.setIsbn("978-3-7657-2781-8");
        assertThat(validator.isValid(book, null)).isTrue();
    }

    @Test
    public void validateIsbnTrue_differentFormat() {
        var book = new Book();
        book.setIsbn("9783765727818");
        assertThat(validator.isValid(book, null)).isTrue();
    }

    @Test
    public void validateIsbnFalse_wrongCheckDigit() {
        var book = new Book();
        book.setIsbn("978-3-8668-0129-9");
        assertThat(validator.isValid(book, null)).isFalse();
    }

    @Test
    public void validateIsbnFalse_wrongFormat() {
        var book = new Book();
        book.setIsbn("123456");
        assertThat(validator.isValid(book, null)).isFalse();
    }

    @Test
    public void validateIsbnFalse_nullBook() {
        assertThat(validator.isValid(null, null)).isFalse();
    }
}
