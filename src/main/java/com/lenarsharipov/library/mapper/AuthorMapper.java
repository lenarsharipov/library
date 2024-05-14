package com.lenarsharipov.library.mapper;

import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.author.CreateAuthorDto;
import com.lenarsharipov.library.model.author.ReadAuthorDto;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class AuthorMapper {

    public static ReadAuthorDto toDto(Author entity) {
        return new ReadAuthorDto(entity.getId(), entity.getName());
    }

    public static List<ReadAuthorDto> toDto(List<Author> list) {
        return list.stream()
                .map(a -> new ReadAuthorDto(a.getId(), a.getName()))
                .toList();
    }

    public static Set<ReadAuthorDto> toDto(Set<Author> set) {
        return set.stream()
                .map(a -> new ReadAuthorDto(a.getId(), a.getName()))
                .collect(Collectors.toSet());

    }

    public static Author toEntity(CreateAuthorDto dto) {
        return Author.builder()
                .name(dto.name())
                .build();
    }

}
