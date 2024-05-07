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
VALUES (1, 'ana@gmail.com', 'Boskovic', 'Ana', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'ancica');
INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (1, 'mila@gmail.com', 'Maksimovic', 'Mila', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'mili');



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
                     category, is_visible, psychologist_id, text)
VALUES (0, true, 2, 'I accept people the way they are.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (3, true, 2, 'I believe in the importance of art.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (3, true, 2, 'I feel comfortable around people.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (1, true, 2, 'I get chores done right away.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (2, true, 2, 'I find it difficult to get to work.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (4, true, 2, 'I stay in the background.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (3, true, 2, 'I have a kind word for everyone.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (1, true, 2, 'I change my plans frequently.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (2, true, 2, 'I avoid philosophical discussions.');
INSERT INTO questions(
    category, is_visible, psychologist_id, text)
VALUES (1, true, 2, 'I seldom feel blue.');





--filledInTests--

