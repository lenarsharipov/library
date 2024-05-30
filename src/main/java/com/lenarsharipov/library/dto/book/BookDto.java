package com.lenarsharipov.library.dto.book;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookDto {

    private Long id;

    private String isbn;

    private String title;

    private List<String> authors;
}
