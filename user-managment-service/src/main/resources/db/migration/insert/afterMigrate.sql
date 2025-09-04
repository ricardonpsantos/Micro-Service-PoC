-- =========================
-- Criação de Roles
-- =========================
INSERT INTO roles (name,description) VALUES ('ROLE_USER','ROLE DE UTILIZADOR COMUM');
INSERT INTO roles (name,description) VALUES ('ROLE_ADMIN','ROLE DE UTILIZADOR ADMIN');


INSERT INTO users (username, password, email) VALUES
('alice', '$2a$10$7Qd7l9FZb1Rj6nq9Zq6wPeQmFZxDqFzFqXQp2/5e8aFfP3uH0aYQe', 'alice@example.com'),
('bob', '$2a$10$7Qd7l9FZb1Rj6nq9Zq6wPeQmFZxDqFzFqXQp2/5e8aFfP3uH0aYQe', 'bob@example.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- Alice -> ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2); -- Alice -> ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- Bob -> ROLE_ADMIN


