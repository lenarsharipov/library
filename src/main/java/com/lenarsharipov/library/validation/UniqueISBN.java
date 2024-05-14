package com.lenarsharipov.library.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueISBNValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueISBN {

    String message() default "ISBN in use";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
