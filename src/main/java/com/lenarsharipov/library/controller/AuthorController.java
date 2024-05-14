package com.lenarsharipov.library.controller;

import com.lenarsharipov.library.mapper.AuthorMapper;
import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.author.AuthorsIdsDto;
import com.lenarsharipov.library.model.author.ReadAuthorDto;
import com.lenarsharipov.library.model.author.CreateAuthorDto;
import com.lenarsharipov.library.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<ReadAuthorDto> getById(@PathVariable Long id) {
        Author foundAuthor = authorService.getById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(AuthorMapper.toDto(foundAuthor));
    }

    @GetMapping
    public ResponseEntity<List<ReadAuthorDto>> getAll() {
        List<Author> foundAuthor = authorService.getAll();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(AuthorMapper.toDto(foundAuthor));
    }

    @GetMapping("/specific")
    public ResponseEntity<Set<ReadAuthorDto>> getAll(@Valid @RequestBody AuthorsIdsDto dto) {
        Set<Author> authors = authorService.getAllByIds(dto.getAuthorsIds());
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(AuthorMapper.toDto(authors));
    }

    @PostMapping
    public ResponseEntity<ReadAuthorDto> create(@Valid @RequestBody CreateAuthorDto authorDto) {
        Author entity = AuthorMapper.toEntity(authorDto);
        Author createdAuthor = authorService.create(entity);
        return ResponseEntity.ok(AuthorMapper.toDto(createdAuthor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadAuthorDto> update(@PathVariable Long id,
                                                @Valid @RequestBody CreateAuthorDto authorDto) {
        Author entity = AuthorMapper.toEntity(authorDto);
        Author updatedAuthor = authorService.update(id, entity);
        return ResponseEntity.ok(AuthorMapper.toDto(updatedAuthor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
