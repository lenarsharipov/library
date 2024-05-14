package com.lenarsharipov.library.service;

import com.lenarsharipov.library.model.book.Book;
import com.lenarsharipov.library.model.book.CreateBookDto;
import com.lenarsharipov.library.model.book.UpdateBookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book getById(Long id);

    Optional<Book> getByIsbn(String isbn);

    List<Book> getAll();

    List<Book> getAllBy(String param);

    Book create(CreateBookDto dto);


    Book update(Long id, UpdateBookDto dto);

    void delete(Long id);

}
