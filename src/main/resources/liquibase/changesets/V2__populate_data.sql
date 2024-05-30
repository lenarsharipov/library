INSERT INTO author(name)
VALUES ('Leo Tolstoy'),
       ('Michael Bulgakov'),
       ('Alexander Pushkin');

INSERT INTO book(isbn, title)
VALUES ('978-2-1234-5680-3', 'Капитанская дочка'),
        ('123-2-1234-4566-3', 'У Лукоморья');

INSERT INTO book_author(book_id, author_id)
VALUES (1, 3),
        (2, 3);

-- INSERT INTO authorName(name, created_at)
-- VALUES ('Leo Tolstoy', now()),
--        ('Michael Bulgakov', now()),
--        ('Alexander Pushkin', now());
--
-- INSERT INTO book(isbn, title, created_at)
-- VALUES ('978-2-1234-5680-3', 'Капитанская дочка', now()),
--        ('123-2-1234-4566-3', 'У Лукоморья', now());
--
-- INSERT INTO book_author(book_id, author_id, created_at)
-- VALUES (1, 3, now()),
--        (2, 3, now());