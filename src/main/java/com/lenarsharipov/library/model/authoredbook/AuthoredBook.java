package com.lenarsharipov.library.model.authoredbook;

import com.lenarsharipov.library.model.BaseEntity;
import com.lenarsharipov.library.model.author.Author;
import com.lenarsharipov.library.model.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "authored_books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthoredBook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
