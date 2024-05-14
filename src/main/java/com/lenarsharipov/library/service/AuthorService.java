package com.lenarsharipov.library.service;

import com.lenarsharipov.library.model.author.Author;

import java.util.List;
import java.util.Set;

public interface AuthorService {

    Author getById(Long id);

    List<Author> getAll();

    Set<Author> getAllByIds(List<Long> authorsIds);

    Author create(Author author);

    Author update(Long id, Author author);

    void delete(Long id);

}
