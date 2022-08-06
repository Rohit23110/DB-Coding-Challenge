DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS counterparty;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bookname VARCHAR(50) NOT NULL
);

CREATE TABLE book_user (
    bookid INT,
    userid INT,
    PRIMARY KEY (bookId, userId),
    FOREIGN KEY (bookId) REFERENCES book(id),
    FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE security (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ISIN VARCHAR(12) NOT NULL,
    CUSIP VARCHAR(9) NOT NULL,
    issuer VARCHAR(250) NOT NULL,
    maturitydate DATE NOT NULL,
    coupon DECIMAL(4,2) NOT NULL,
    type VARCHAR(50) NOT NULL,
    facevalue INT NOT NULL,
    status VARCHAR(6) NOT NULL
);

CREATE TABLE counterparty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE trade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bookid INT NOT NULL,
    userid INT NOT NULL,
    counterpartyid INT NOT NULL,
    securityid INT NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(10) NOT NULL,
    price INT NOT NULL,
    buysell BOOLEAN NOT NULL,
    tradedate DATE NOT NULL,
    settlementdate DATE NOT NULL,
    FOREIGN KEY (bookid) REFERENCES book(id),
    FOREIGN KEY (userid) REFERENCES users(id),
    FOREIGN KEY (counterpartyid) REFERENCES counterparty(id),
    FOREIGN KEY (securityid) REFERENCES security(id)
);
