package com.lenarsharipov.library.dto.book;

import jakarta.validation.constraints.NotNull;

public record AddBookAuthorDto(
        @NotNull(message = "Author id cannot be null")
        Long authorId
) {
}
