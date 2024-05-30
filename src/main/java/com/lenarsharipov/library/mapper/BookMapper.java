package com.lenarsharipov.library.mapper;

import com.lenarsharipov.library.dto.book.BookDto;
import com.lenarsharipov.library.model.Author;
import com.lenarsharipov.library.model.Book;
import lombok.experimental.UtilityClass;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class BookMapper {

    public static BookDto toDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .authors(book.getAuthors().stream()
                        .map(Author::getName)
                        .collect(toList()))
                .build();
    }
}
