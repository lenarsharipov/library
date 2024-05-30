package com.lenarsharipov.library.repository;

import com.lenarsharipov.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByIdIn(List<Long> authorIds);
}
