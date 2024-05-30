CREATE TABLE IF NOT EXISTS book
(
    id         BIGSERIAL PRIMARY KEY,
    isbn       VARCHAR(17)  NOT NULL UNIQUE,
    title      VARCHAR(128) NOT NULL
--     created_at TIMESTAMP    NOT NULL,
--     updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS author
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(128) NOT NULL
--     created_at TIMESTAMP    NOT NULL,
--     updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS book_author
(
--     id         BIGSERIAL PRIMARY KEY,
    book_id    BIGINT REFERENCES book (id),
    author_id  BIGINT REFERENCES author (id),
    PRIMARY KEY (book_id, author_id)
--     created_at TIMESTAMP NOT NULL,
--     updated_at TIMESTAMP
);