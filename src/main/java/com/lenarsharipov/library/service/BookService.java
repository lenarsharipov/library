package com.lenarsharipov.library.service;

import com.lenarsharipov.library.dto.BookFiltersDto;
import com.lenarsharipov.library.dto.UpdateBookDto;
import com.lenarsharipov.library.dto.book.AddBookAuthorDto;
import com.lenarsharipov.library.dto.book.BookDto;
import com.lenarsharipov.library.dto.book.CreateBookDto;
import com.lenarsharipov.library.dto.page.PageBookDto;
import com.lenarsharipov.library.exception.ResourceNotFoundException;
import com.lenarsharipov.library.mapper.BookMapper;
import com.lenarsharipov.library.mapper.BookPageMapper;
import com.lenarsharipov.library.mapper.BookSpecificationMapper;
import com.lenarsharipov.library.model.Author;
import com.lenarsharipov.library.model.Book;
import com.lenarsharipov.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Transactional
    public BookDto create(CreateBookDto dto) {
        Book book = Book.builder()
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .build();
        bookRepository.save(book);
        List<Author> authors = authorService.getByIds(dto.getAuthorsIds());
        book.setAuthors(authors);
        return BookMapper.toDto(book);
    }

    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));
    }

    @Transactional
    public BookDto update(Long id, UpdateBookDto dto) {
        Book book = getById(id);
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        return BookMapper.toDto(book);
    }

    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDto addAuthor(Long id, AddBookAuthorDto dto) {
        Book book = getById(id);
        Author author = authorService.getById(dto.authorId());
        if (!book.getAuthors().contains(author)) {
            book.getAuthors().add(author);
        }
        return BookMapper.toDto(book);
    }

    public BookDto deleteAuthor(Long bookId, Long authorId) {
        Book book = getById(bookId);
        Author author = authorService.getById(authorId);
        book.getAuthors().remove(author);
        return BookMapper.toDto(book);
    }

    public PageBookDto search(BookFiltersDto filters, Pageable pageable) {
        Specification<Book> specification = BookSpecificationMapper.toSpecification(filters);
        Page<Book> bookPage = bookRepository.findAll(specification, pageable);
        return BookPageMapper.toPageBookDto(bookPage);
    }
}