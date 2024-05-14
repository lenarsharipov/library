package com.lenarsharipov.library.model.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateBookDto {

    @NotNull(message = "ISBN cannot be null")
    @ISBN(message = "Illegal ISBN number")
    private String isbn;

    @NotNull(message = "Title cannot be null")
    @Length(min = 1,
            max = 128,
            message = "Tittle length must be between 1 and 128 characters")
    private String title;

    @NotNull
    @NotEmpty
    @UniqueElements
    List<Long> authorsIds = new ArrayList<>();

}
