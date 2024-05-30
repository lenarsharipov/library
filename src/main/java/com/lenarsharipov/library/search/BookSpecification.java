package com.lenarsharipov.library.search;

import com.lenarsharipov.library.model.Author;
import com.lenarsharipov.library.model.Book;
import jakarta.persistence.criteria.*;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Builder
//@Getter
//@Setter
public record BookSpecification(
        String isbn,
        String title,
        String authorName) implements Specification<Book> {

    @Override
    public Predicate toPredicate(@NonNull Root<Book> root,
                                 @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (isbn != null && !isbn.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("isbn"), this.isbn));
        }

        if (title != null && !title.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + this.title + "%"));
        }

        if (authorName != null && !authorName.isEmpty()) {
            Join<Book, Author> authors = root.join("authors", JoinType.INNER);
            predicates.add(criteriaBuilder.like(authors.get("name"), "%" + this.authorName + "%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
