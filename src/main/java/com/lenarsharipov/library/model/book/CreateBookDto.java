package com.lenarsharipov.library.model.book;

import com.lenarsharipov.library.validation.UniqueISBN;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookDto {

    @NotNull(message = "ISBN cannot be null")
    @UniqueISBN
    @ISBN(message = "Illegal ISBN number")
    private String isbn;

    @NotNull(message = "Title cannot be null")
    @Length(min = 1,
            max = 128,
            message = "Tittle length must be between 1 and 128 characters")
    private String title;

    @NotNull(message = "List of ids cannot be null")
    @UniqueElements(message = "List must contain only unique elements")
    private List<Long> authorsIds = new ArrayList<>();

}
