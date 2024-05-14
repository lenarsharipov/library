package com.lenarsharipov.library.service.impl;

import com.lenarsharipov.library.exception.ResourceNotFoundException;
import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.repository.AuthorRepository;
import com.lenarsharipov.library.service.AuthorService;
import com.lenarsharipov.library.service.AuthoredBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthoredBookService authoredBookService;

    @Override
    @Transactional(readOnly = true)
    public Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Author not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Author> getAllByIds(List<Long> authorsIds) {
        return authorRepository.findByIdIn(authorsIds);
    }

    @Override
    @Transactional
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author update(Long id, Author author) {
        Author persistedAuthor = getById(id);
        persistedAuthor.setName(author.getName());
        return authorRepository.save(persistedAuthor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Author author = getById(id);
        authoredBookService.nullifyAuthor(author);
        authorRepository.deleteById(id);
    }

}