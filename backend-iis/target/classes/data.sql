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
INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (1, 'mila@gmail.com', 'maksimovic', 'mila', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'mili');



INSERT INTO psychologist(
                         id, biography)
VALUES (2,'kratka biografija');


INSERT INTO registered_user(
                            is_student, id)
VALUES (false, 3);
INSERT INTO registered_user(
    is_student, id)
VALUES (false, 4);

--questions--
INSERT INTO questions(
                      id, category, is_visible, psychologist_id, text)
VALUES (1, 0, true, 2, 'neko pitanje');
INSERT INTO questions(
    id, category, is_visible, psychologist_id, text)
VALUES (2, 3, true, 2, 'kratko pitanje');


--filledInTests--
INSERT INTO filled_in_test(
    id, is_finished, finished_date, registered_user_id)
VALUES (1, true, '2024-04-28T12:00:00Z' , 3);
