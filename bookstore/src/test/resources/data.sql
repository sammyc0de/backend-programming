-- Category
INSERT INTO category (name)
VALUES ('Computer');

-- Book
INSERT INTO book (
    title,
    author,
    publication_year,
    isbn,
    price,
    categoryid
)
VALUES (
    'Modern operating systems',
    'Tim Walls',
    2022,
    '978164-45',
    49.90,
    1
);

-- Users
INSERT INTO app_user (
    username,
    password_hash,
    email,
    role
)
VALUES (
    'user1',
    '$2a$10$1nzWR.4DwZRUm3rdhNCkSOklsyCphKp1Ydkq3lETnPx99oAa3F9Ti',
    'user@bookstore.com',
    'USER'
);

INSERT INTO app_user (
    username,
    password_hash,
    email,
    role
)
VALUES (
    'admin1',
    '$2a$10$3JleYlauJBlqY47vqfbj4.xAJ.0QIhpQW5A1U0r2fNQK7kXj3V.hq',
    'admin@bookstore.com',
    'ADMIN'
);