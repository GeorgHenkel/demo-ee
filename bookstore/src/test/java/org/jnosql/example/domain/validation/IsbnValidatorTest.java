package org.jnosql.example.domain.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsbnValidatorTest {
    private final IsbnValidator validator = new IsbnValidator();

    @Test
    public void validateIsbnTrue() {
        assertThat(validator.isValid("978-3-7657-2781-8", null)).isTrue();
    }

    @Test
    public void validateIsbnTrue_differentFormat() {
        assertThat(validator.isValid("9783765727818", null)).isTrue();
    }

    @Test
    public void validateIsbnFalse_wrongCheckDigit() {
        assertThat(validator.isValid("978-3-8668-0129-9", null)).isFalse();
    }

    @Test
    public void validateIsbnFalse_wrongFormat() {
        assertThat(validator.isValid("123456", null)).isFalse();
    }

    @Test
    public void validateIsbnFalse_nullBook() {
        assertThat(validator.isValid(null, null)).isFalse();
    }
}
