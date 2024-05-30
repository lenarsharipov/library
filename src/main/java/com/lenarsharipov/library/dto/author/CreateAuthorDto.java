package com.lenarsharipov.library.dto.author;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CreateAuthorDto(

        @NotNull(message = "Name cannot be null")
        @Length(min = 2,
                max = 128,
                message = "Name length must be between 2 and 128 characters length")
        String name) {
}
