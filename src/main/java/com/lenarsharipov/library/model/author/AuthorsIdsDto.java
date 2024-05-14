package com.lenarsharipov.library.model.author;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorsIdsDto {

    @NotNull(message = "List of ids cannot be null")
    @UniqueElements(message = "List must contain only unique elements")
    private List<Long> authorsIds = new ArrayList<>();

}
