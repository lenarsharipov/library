CREATE TABLE IF NOT EXISTS books
(
    id         BIGSERIAL PRIMARY KEY,
    isbn       VARCHAR(17)  NOT NULL UNIQUE,
    title      VARCHAR(128) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS authors
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(128) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS authored_books
(
    id         BIGSERIAL PRIMARY KEY,
    book_id    BIGINT REFERENCES books (id),
    author_id  BIGINT REFERENCES authors (id),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);