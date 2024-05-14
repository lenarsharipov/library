package com.lenarsharipov.library.model.book;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ReadBookDto {

    private Long id;

    private String isbn;

    private String title;

    private Set<String> authors;

}
