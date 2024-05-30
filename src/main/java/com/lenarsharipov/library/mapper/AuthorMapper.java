package com.lenarsharipov.library.mapper;

import com.lenarsharipov.library.dto.author.CreateAuthorDto;
import com.lenarsharipov.library.dto.author.AuthorDto;
import com.lenarsharipov.library.model.Author;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class AuthorMapper {

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    public static List<AuthorDto> toDto(List<Author> authors) {
        return authors.stream()
                .map(a -> new AuthorDto(a.getId(), a.getName()))
                .collect(Collectors.toList());

    }

    public static Author toEntity(CreateAuthorDto dto) {
        return Author.builder()
                .name(dto.name())
                .build();
    }
}