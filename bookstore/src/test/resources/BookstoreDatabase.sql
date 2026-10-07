DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS category;

CREATE TABLE category (
categoryid BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(100) NOT NULL
);

CREATE TABLE book (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
title VARCHAR(255) NOT NULL,
author VARCHAR(255) NOT NULL,
publication_year INTEGER NOT NULL,
isbn VARCHAR(50) NOT NULL,
price DECIMAL(10,2) NOT NULL,
categoryid BIGINT NOT NULL,
CONSTRAINT fk_book_category
FOREIGN KEY (categoryid)
REFERENCES category(categoryid)
);

CREATE TABLE app_user (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
passwordHash VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
role VARCHAR(20) NOT NULL
);

-- Category
INSERT INTO category (name) VALUES
    ('Computer'),
    ('Educational'),
    ('Classics'),
    ('Comics');
-- Book
INSERT INTO book (
    title,
    author,
    publication_year,
    isbn,
    price,
    categoryid
)
VALUES
    ('Modern Operating Systems', 'Tim Woods', 2022, '978164-45', 49.90, 1),
    ('Example Book', 'Robert Author', 2026, '9780156-48', 29.90, 3),
    ('Nature Book', 'Philip Downing', 2021, '358756-48', 19.90, 2);

-- Users
INSERT INTO app_user (
    username,
    passwordHash,
    email,
    role
)
VALUES (
    'user',
    '$2a$10$1nzWR.4DwZRUm3rdhNCkSOklsyCphKp1Ydkq3lETnPx99oAa3F9Ti',
    'user@bookstore.com',
    'USER'
);

INSERT INTO app_user (
    username,
    passwordHash,
    email,
    role
)
VALUES (
    'admin',
    '$2a$10$3JleYlauJBlqY47vqfbj4.xAJ.0QIhpQW5A1U0r2fNQK7kXj3V.hq',
    'admin@bookstore.com',
    'ADMIN'
);