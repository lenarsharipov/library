INSERT INTO authors(name, created_at, updated_at)
VALUES ('Leo Tolstoy', now(), now()),
       ('Michael Bulgakov', now(), now()),
       ('Alexander Pushkin', now(), now());

INSERT INTO books(isbn, title, created_at, updated_at)
VALUES ('978-2-1234-5680-3', 'Капитанская дочка', now(), now()),
        ('123-2-1234-4566-3', 'У Лукоморья', now(), now());

INSERT INTO authored_books(book_id, author_id, created_at, updated_at)
VALUES (1, 3, now(), now()),
        (2, 3, now(), now());