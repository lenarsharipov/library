package com.lenarsharipov.library.mapper;

import com.lenarsharipov.library.dto.book.BookDto;
import com.lenarsharipov.library.dto.page.PageBookDto;
import com.lenarsharipov.library.model.Book;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class BookPageMapper {
    public static PageBookDto toPageBookDto(Page<Book> bookPage) {
        return PageBookDto.builder()
                .content(toReturnUserDto(bookPage))
                .pageNumber(bookPage.getNumber() + 1)
                .pageSize(bookPage.getSize())
                .numberOfElements(bookPage.getNumberOfElements())
                .totalElements(bookPage.getTotalElements())
                .totalPages(bookPage.getTotalPages())
                .isFirst(bookPage.isFirst())
                .isEmpty(bookPage.isEmpty())
                .build();
    }

    public static List<BookDto> toReturnUserDto(Page<Book> bookPage) {
        return bookPage.getContent().stream()
                .map(BookMapper::toDto)
                .collect(toList());
    }
}
