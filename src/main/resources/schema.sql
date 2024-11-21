CREATE TABLE token (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    wallet_address VARCHAR(100) NOT NULL UNIQUE,
    balance INT NOT NULL DEFAULT 0.0
);