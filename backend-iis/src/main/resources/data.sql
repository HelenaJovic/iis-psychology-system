INSERT INTO roles (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO roles (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_STUDENT');
INSERT INTO roles (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
     role_id, email,image, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'https://pacifichealthsystems.com/wp-content/uploads/2020/11/Psychologist-san-diego.jpg','adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin');
INSERT INTO users(
     role_id, email,image, last_name, name, password, username)
VALUES (1, 'user1@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'user1', 'user1', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user1');
INSERT INTO users(
     role_id, email,image, last_name, name, password, username)
VALUES (1, 'user2@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'user2', 'user2', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user2');
INSERT INTO users(
     role_id, email,image, last_name, name, password, username)
VALUES (1, 'user3@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'user3', 'user3', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user3');
INSERT INTO users(
     role_id, email,image, last_name, name, password, username)
VALUES (4, 'psiholog@gmail.com','https://pacifichealthsystems.com/wp-content/uploads/2020/11/Psychologist-san-diego.jpg', 'psiho', 'psiho', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'psiholog');
INSERT INTO users(
     role_id, email,image, last_name, name, password, username)
VALUES (4, 'psiholo2g@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'psiho2', 'psiho2', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'psiholog2');


INSERT INTO halls(
	capacity, is_free, name)
	VALUES (10, true, 'A1');
INSERT INTO halls(
	capacity, is_free, name)
	VALUES (30, true, 'A2');
INSERT INTO halls(
	capacity, is_free, name)
	VALUES (100, true, 'A3');
INSERT INTO halls(
	capacity, is_free, name)
	VALUES (5, true, 'A4');

INSERT INTO registered_user(
	is_student, id)
	VALUES (false,2);

INSERT INTO registered_user(
	is_student, id)
	VALUES (false,3);

INSERT INTO registered_user(
	is_student, id)
	VALUES (false,4);

INSERT INTO psychologist(
	id, biography)
	VALUES (5, 'biography');

INSERT INTO psychologist(
	id, biography)
	VALUES (6, 'biography');

INSERT INTO workshops(
	category, is_online, price, date, hall_id,psychologist_id, description, end_time, name, start_time)
	VALUES (0, false, 30, '2024-05-01', 1,5, 'A workshop designed to introduce participants to the basics of anxiety', '11:00:00', 'Understanding Anxiety: Tools to Regain Control','09:00:00');
INSERT INTO workshops(
	category, is_online, price, date, hall_id, psychologist_id, description, end_time, name, start_time)
	VALUES (0, true, 60, '2024-05-10', null, 6, 'A workshop designed to introduce participants to the basics of anxiety', '11:00:00', 'From Anxious to Assured:Anxiety solver','09:00:00');
INSERT INTO workshops(
	category, is_online, price, date, hall_id, psychologist_id, description, end_time, name, start_time)
	VALUES (6, false, 60, '2024-05-12', 3,5, 'A workshop designed to introduce participants to the basics of couples therapy', '11:00:00', 'Love and Understanding: A Couples Workshop','09:00:00');
INSERT INTO workshops(
	category, is_online, price, date, hall_id,  psychologist_id, description, end_time, name, start_time)
	VALUES (8, false, 160, '2024-05-12', 2,5, 'A workshop designed to introduce participants to the basics of trauma recovery', '11:00:00', 'Pathways to Healing: Overcoming Trauma Together','09:00:00');

INSERT INTO user_workshops(
	is_canceled,  user_id, workshop_id)
	VALUES (false, 2, 1);
INSERT INTO user_workshops(
	is_canceled,user_id, workshop_id)
	VALUES (false, 3, 1);
	--questions--
    INSERT INTO questions(
                         category, is_visible, psychologist_id, text)
    VALUES (0, true, 5, 'I accept people the way they are.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (3, true, 5, 'I believe in the importance of art.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (3, true, 5, 'I feel comfortable around people.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (1, true, 5, 'I get chores done right away.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (2, true, 5, 'I find it difficult to get to work.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (4, true, 5, 'I stay in the background.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (3, true, 5, 'I have a kind word for everyone.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (1, true, 5, 'I change my plans frequently.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (2, true, 5, 'I avoid philosophical discussions.');
    INSERT INTO questions(
        category, is_visible, psychologist_id, text)
    VALUES (1, true, 5, 'I seldom feel blue.');
