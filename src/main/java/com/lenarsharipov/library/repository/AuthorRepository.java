package com.lenarsharipov.library.repository;

import com.lenarsharipov.library.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> findByIdIn(List<Long> authorIds);
}
