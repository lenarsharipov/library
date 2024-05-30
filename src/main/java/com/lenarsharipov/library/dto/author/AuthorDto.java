package com.lenarsharipov.library.dto.author;

import lombok.Builder;

@Builder
public record AuthorDto(Long id, String name) {

}
