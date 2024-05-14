package com.lenarsharipov.library.mapper;

import com.lenarsharipov.library.model.book.Book;
import com.lenarsharipov.library.model.book.ReadBookDto;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BookMapper {

    public static ReadBookDto toDto(Book book) {
        return ReadBookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .authors(book.getAuthoredBooks().stream()
                        .filter(ab -> ab.getAuthor() != null)
                        .map(ab -> ab.getAuthor().getName())
                        .collect(Collectors.toSet()))
                .build();
    }

    public static List<ReadBookDto> toDto(List<Book> books) {
        return books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

}
