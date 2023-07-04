package org.jnosql.example.domain.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = IsbnValidator.class)
@Target({FIELD, METHOD})
@Retention(RUNTIME)
@Documented
public @interface ValidIsbn {
    String message() default "ISBN not valid (checksum is wrong)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
