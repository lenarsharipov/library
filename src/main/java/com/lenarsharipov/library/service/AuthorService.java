package com.lenarsharipov.library.service;

import com.lenarsharipov.library.dto.author.CreateAuthorDto;
import com.lenarsharipov.library.dto.author.AuthorDto;
import com.lenarsharipov.library.exception.ResourceNotFoundException;
import com.lenarsharipov.library.mapper.AuthorMapper;
import com.lenarsharipov.library.model.Author;
import com.lenarsharipov.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public AuthorDto create(CreateAuthorDto dto) {
        Author author = AuthorMapper.toEntity(dto);
        authorRepository.save(author);
        return AuthorMapper.toDto(author);
    }

    public Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Author not found"));
    }

    @Transactional
    public AuthorDto update(Long id, CreateAuthorDto dto) {
        Author author = getById(id);
        author.setName(dto.name());
        return AuthorMapper.toDto(author);
    }

    public List<AuthorDto> getAll() {
        List<Author> authors = authorRepository.findAll();
        return AuthorMapper.toDto(authors);
    }

    public List<Author> getByIds(List<Long> ids) {
        return authorRepository.findByIdIn(ids);
    }

    @Transactional
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}