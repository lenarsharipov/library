package com.lenarsharipov.library.controller;

import com.lenarsharipov.library.dto.BookFiltersDto;
import com.lenarsharipov.library.dto.book.AddBookAuthorDto;
import com.lenarsharipov.library.dto.book.CreateBookDto;
import com.lenarsharipov.library.dto.UpdateBookDto;
import com.lenarsharipov.library.dto.book.BookDto;
import com.lenarsharipov.library.dto.page.PageBookDto;
import com.lenarsharipov.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@Valid @RequestBody CreateBookDto dto) {
        return bookService.create(dto);
    }

    @PutMapping("/{id}")
    public BookDto update(@PathVariable Long id,
                          @Valid @RequestBody UpdateBookDto dto) {
        return bookService.update(id, dto);
    }

    @PostMapping("/{id}/authors")
    public BookDto addAuthor(@PathVariable Long id,
                            @Valid @RequestBody AddBookAuthorDto dto) {
        return bookService.addAuthor(id, dto);
    }

    @DeleteMapping("/{bookId}/authors/{authorId}")
    public BookDto deleteAuthor(@PathVariable Long bookId,
                             @PathVariable Long authorId) {
        return bookService.deleteAuthor(bookId, authorId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/search")
    public PageBookDto search(BookFiltersDto filters,
                              @PageableDefault(direction = Sort.Direction.ASC)
                              Pageable pageable) {
        return bookService.search(filters, pageable);
    }
}