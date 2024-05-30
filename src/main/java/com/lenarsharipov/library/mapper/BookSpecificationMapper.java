package com.lenarsharipov.library.mapper;

import com.lenarsharipov.library.dto.BookFiltersDto;
import com.lenarsharipov.library.search.BookSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookSpecificationMapper {

    public static BookSpecification toSpecification(BookFiltersDto filters) {
        return BookSpecification.builder()
                .authorName(filters.getAuthor())
                .isbn(filters.getIsbn())
                .title(filters.getTitle())
                .build();
    }
}
