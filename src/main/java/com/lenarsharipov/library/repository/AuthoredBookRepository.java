package com.lenarsharipov.library.repository;

import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.authoredbook.AuthoredBook;
import com.lenarsharipov.library.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoredBookRepository extends JpaRepository<AuthoredBook, Long> {

    List<AuthoredBook> findByAuthorAndAndBook(Author author, Book book);

    List<AuthoredBook> findByAuthor(Author author);

    List<AuthoredBook> findByBook(Book book);

    void deleteAllByBook(Book book);

}
