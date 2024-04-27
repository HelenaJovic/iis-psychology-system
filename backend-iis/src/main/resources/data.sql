INSERT INTO roles (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO roles (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_STUDENT');
INSERT INTO roles (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
     role_id, email, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin');
INSERT INTO users(
     role_id, email, last_name, name, password, username)
VALUES (1, 'user1@gmail.com', 'user1', 'user1', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user1');
INSERT INTO users(
     role_id, email, last_name, name, password, username)
VALUES (4, 'psiholog@gmail.com', 'psiho', 'psiho', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'psiholog');