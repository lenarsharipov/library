package com.lenarsharipov.library.service.impl;

import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.authoredbook.AuthoredBook;
import com.lenarsharipov.library.model.book.Book;
import com.lenarsharipov.library.repository.AuthoredBookRepository;
import com.lenarsharipov.library.service.AuthoredBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthoredBookServiceImpl implements AuthoredBookService {

    private final AuthoredBookRepository authoredBookRepository;

    @Override
    public void createAll(Set<AuthoredBook> authoredBooks) {
        authoredBookRepository.saveAll(authoredBooks);
    }

    @Override
    public void create(Author author, Book book) {
        AuthoredBook authoredBook = new AuthoredBook();
        authoredBook.setAuthor(author);
        authoredBook.setBook(book);
        authoredBookRepository.save(authoredBook);
    }

    @Override
    public void nullifyAuthor(Author author) {
        List<AuthoredBook> byAuthor = authoredBookRepository.findByAuthor(author);
        byAuthor.forEach(ab -> ab.setAuthor(null));
        authoredBookRepository.saveAll(byAuthor);
    }

    @Override
    public void nullifyBook(Book book) {
        List<AuthoredBook> byBook = authoredBookRepository.findByBook(book);
        byBook.forEach(ab -> ab.setBook(null));
        authoredBookRepository.saveAll(byBook);
    }

    @Override
    public void deleteAll(Set<AuthoredBook> authoredBooks) {
        authoredBookRepository.deleteAll(authoredBooks);
    }

}