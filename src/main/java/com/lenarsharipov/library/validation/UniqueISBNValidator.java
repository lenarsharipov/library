package com.lenarsharipov.library.validation;

import com.lenarsharipov.library.repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueISBNValidator implements ConstraintValidator<UniqueISBN, String> {

    private final BookRepository bookRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && bookRepository.findByIsbn(value).isEmpty();
    }

}
