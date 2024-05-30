package com.lenarsharipov.library.dto.page;


import com.lenarsharipov.library.dto.book.BookDto;
import lombok.Builder;

import java.util.List;

@Builder
public record PageBookDto(
        List<BookDto> content,
        int pageNumber,
        int pageSize,
        long numberOfElements,
        long totalElements,
        int totalPages,
        boolean isFirst,
        boolean isEmpty
) {
}
