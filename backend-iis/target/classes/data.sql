INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin');
INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (4, 'psiholog@gmail.com', 'prezime', 'psiholog', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'psiholog');
INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (1, 'ana@gmail.com', 'boskovic', 'ana', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'ancica');


INSERT INTO psychologist(
                         id, biography)
VALUES (2,'kratka biografija');



