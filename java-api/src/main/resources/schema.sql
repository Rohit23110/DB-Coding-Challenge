DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS counterparty;

CREATE TABLE users (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE book (
    id INT PRIMARY KEY,
    bookName VARCHAR(50) NOT NULL
);

CREATE TABLE book_user (
    bookId INT,
    userId INT,
    PRIMARY KEY (bookId, userId),
    FOREIGN KEY (bookId) REFERENCES book(id),
    FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE security (
    id INT NOT NULL PRIMARY KEY,
    ISIN VARCHAR(12) NOT NULL,
    CUSIP VARCHAR(9) NOT NULL,
    issuer VARCHAR(250) NOT NULL,
    maturitydate DATETIME NOT NULL,
    coupon DECIMAL(4,2) NOT NULL,
    type VARCHAR(50) NOT NULL,
    facevalue INT NOT NULL,
    status VARCHAR(6) NOT NULL
);

CREATE TABLE counterparty (
    id INT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE trade (
    id INT PRIMARY KEY,
    bookId INT NOT NULL,
    userId INT NOT NULL,
    counterpartyId INT NOT NULL,
    securityId INT NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(10) NOT NULL,
    price INT NOT NULL,
    buySell BOOLEAN NOT NULL,
    tradeDate DATETIME NOT NULL,
    settlementDate DATETIME NOT NULL,
    FOREIGN KEY (bookId) REFERENCES book(id),
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (counterpartyId) REFERENCES counterparty(id),
    FOREIGN KEY (securityId) REFERENCES security(id)
);
