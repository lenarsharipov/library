INSERT INTO authors(name, created_at)
VALUES ('Leo Tolstoy', now()),
       ('Michael Bulgakov', now()),
       ('Alexander Pushkin', now());

INSERT INTO books(isbn, title, created_at)
VALUES ('978-2-1234-5680-3', 'Капитанская дочка', now()),
        ('123-2-1234-4566-3', 'У Лукоморья', now());

INSERT INTO authored_books(book_id, author_id, created_at)
VALUES (1, 3, now()),
        (2, 3, now());