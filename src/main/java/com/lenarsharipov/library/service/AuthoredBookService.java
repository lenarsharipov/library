package com.lenarsharipov.library.service;

import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.authoredbook.AuthoredBook;
import com.lenarsharipov.library.model.book.Book;

import java.util.Set;

public interface AuthoredBookService {

    void createAll(Set<AuthoredBook> authoredBooks);

    void create(Author author, Book book);

    void nullifyAuthor(Author author);

    void nullifyBook(Book book);

    void deleteAll(Set<AuthoredBook> authoredBooks);

}
