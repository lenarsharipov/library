package com.lenarsharipov.library.controller;

import com.lenarsharipov.library.dto.author.CreateAuthorDto;
import com.lenarsharipov.library.dto.author.AuthorDto;
import com.lenarsharipov.library.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto create(@Valid @RequestBody CreateAuthorDto authorDto) {
        return authorService.create(authorDto);
    }

    @GetMapping
    public List<AuthorDto> getAll() {
        return authorService.getAll();
    }

    @PutMapping("/{id}")
    public AuthorDto update(@PathVariable Long id,
                            @Valid @RequestBody CreateAuthorDto dto) {
        return authorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
