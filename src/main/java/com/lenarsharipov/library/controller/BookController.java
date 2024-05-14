package com.lenarsharipov.library.controller;

import com.lenarsharipov.library.mapper.BookMapper;
import com.lenarsharipov.library.model.book.Book;
import com.lenarsharipov.library.model.book.CreateBookDto;
import com.lenarsharipov.library.model.book.ReadBookDto;
import com.lenarsharipov.library.model.book.UpdateBookDto;
import com.lenarsharipov.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<ReadBookDto> create(@Valid @RequestBody CreateBookDto dto) {
        Book createdBook = bookService.create(dto);
        return ResponseEntity.ok(BookMapper.toDto(createdBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadBookDto> update(@PathVariable Long id,
                                              @Valid @RequestBody UpdateBookDto dto) {
        Book updatedBook = bookService.update(id, dto);
        ReadBookDto readBookDto = BookMapper.toDto(updatedBook);
        return ResponseEntity.ok(readBookDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadBookDto> getById(@PathVariable Long id) {
        Book persistedBook = bookService.getById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(BookMapper.toDto(persistedBook));
    }

    @GetMapping
    public ResponseEntity<List<ReadBookDto>> getAllSortedBy(@RequestParam String sortBy) {
        List<Book> persistedBooks = bookService.getAllBy(sortBy);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(BookMapper.toDto(persistedBooks));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
