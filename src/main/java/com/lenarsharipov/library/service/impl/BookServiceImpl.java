package com.lenarsharipov.library.service.impl;

import com.lenarsharipov.library.exception.UniqueFieldException;
import com.lenarsharipov.library.exception.ResourceNotFoundException;
import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.authoredbook.AuthoredBook;
import com.lenarsharipov.library.model.book.Book;
import com.lenarsharipov.library.model.book.CreateBookDto;
import com.lenarsharipov.library.model.book.UpdateBookDto;
import com.lenarsharipov.library.repository.BookRepository;
import com.lenarsharipov.library.service.AuthorService;
import com.lenarsharipov.library.service.AuthoredBookService;
import com.lenarsharipov.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final AuthoredBookService authoredBookService;

    @Override
    @Transactional(readOnly = true)
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBy(String param) {
        if ("isbn".equals(param)) {
            return bookRepository.findByOrderByIsbn();
        } else if ("title".equals(param)) {
            return bookRepository.findByOrderByTitle();
        } else if ("author".equals(param)) {
            return bookRepository.findByOrderByAuthoredBooksAuthor();
        }
        return getAll();
    }

    @Override
    @Transactional
    public Book create(CreateBookDto dto) {
        Book book = Book.builder()
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .build();
        Book savedBook = bookRepository.save(book);

        Set<Author> authors = getAuthors(dto.getAuthorsIds());
        Set<AuthoredBook> authoredBooks = authors.stream()
                .map(author -> AuthoredBook.builder()
                        .author(author)
                        .book(savedBook)
                        .build())
                .collect(toSet());
        authoredBookService.createAll(authoredBooks);

        savedBook.setAuthoredBooks(authoredBooks);

        return savedBook;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> getByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    @Transactional
    public Book update(Long id, UpdateBookDto dto) {
        Book persistedBook = getById(id);
        Optional<Book> foundByIsbn = getByIsbn(dto.getIsbn());
        if (foundByIsbn.isPresent()
            && !foundByIsbn.get().getIsbn().equals(persistedBook.getIsbn())) {
            throw new UniqueFieldException("Passed isbn is in use");
        }

        authoredBookService.deleteAll(persistedBook.getAuthoredBooks());

        Set<Author> newAuthors = getAuthors(dto.getAuthorsIds());
        Set<AuthoredBook> newAuthoredBooks = newAuthors.stream()
                .map(author -> AuthoredBook.builder()
                        .author(author)
                        .book(persistedBook)
                        .build())
                .collect(toSet());
        authoredBookService.createAll(newAuthoredBooks);

        persistedBook.setIsbn(dto.getIsbn());
        persistedBook.setTitle(dto.getTitle());
        persistedBook.setAuthoredBooks(newAuthoredBooks);
        bookRepository.save(persistedBook);

        return persistedBook;
    }

    private Set<Author> getAuthors(List<Long> authorsIds) {
        return authorService.getAllByIds(authorsIds);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Book book = getById(id);
        authoredBookService.nullifyBook(book);
        bookRepository.deleteById(id);
    }

}