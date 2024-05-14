package com.lenarsharipov.library.model.author;

import com.lenarsharipov.library.model.BaseEntity;
import com.lenarsharipov.library.model.authoredbook.AuthoredBook;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "authors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "authoredBooks")
@EqualsAndHashCode(of = "id")
public class Author extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "author")
    Set<AuthoredBook> authoredBooks = new HashSet<>();

}