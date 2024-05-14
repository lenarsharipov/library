package com.lenarsharipov.library.model.book;

import com.lenarsharipov.library.model.BaseEntity;
import com.lenarsharipov.library.model.authoredbook.AuthoredBook;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@ToString(exclude = "authoredBooks")
@EqualsAndHashCode(of = "isbn")
@Entity
@Table(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    @Builder.Default
    @OneToMany(mappedBy = "book")
    Set<AuthoredBook> authoredBooks = new HashSet<>();

}
