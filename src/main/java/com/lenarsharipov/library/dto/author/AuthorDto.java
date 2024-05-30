package com.lenarsharipov.library.dto.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class AuthorDto {

    Long id;
    String name;
}
