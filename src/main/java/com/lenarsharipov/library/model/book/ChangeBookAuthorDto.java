package com.lenarsharipov.library.model.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ChangeBookAuthorDto {

    @NotNull(message = "Author id cannot be null")
    @Positive(message = "Author id has a positive value")
    private Long authorId;
}
