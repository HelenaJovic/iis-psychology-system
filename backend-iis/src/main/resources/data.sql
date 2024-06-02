INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
     gender,role_id, email,image, last_name, name, password, username)
VALUES (0,2, 'admin@gmail.com', 'https://pacifichealthsystems.com/wp-content/uploads/2020/11/Psychologist-san-diego.jpg','adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin');
INSERT INTO users(
    gender, role_id, email,image, last_name, name, password, username)
VALUES (0,1, 'user1@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'Jovic', 'Helena', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user1');
INSERT INTO users(
     gender,role_id, email,image, last_name, name, password, username)
VALUES (0,1, 'user2@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'Knezevic', 'Nina', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user2');
INSERT INTO users(
    gender, role_id, email,image, last_name, name, password, username)
VALUES (1,1, 'user3@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'Zugic', 'Boris', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'user3');
INSERT INTO users(
     gender,role_id, email,image, last_name, name, password, username)
VALUES (1,4, 'psiholog@gmail.com','https://pacifichealthsystems.com/wp-content/uploads/2020/11/Psychologist-san-diego.jpg', 'Boskovic', 'Ana', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'psiholog');
INSERT INTO users(
    gender, role_id, email,image, last_name, name, password, username)
VALUES (1,4, 'psiholo2g@gmail.com','https://online.maryville.edu/wp-content/uploads/sites/97/2023/09/female-psychologist-1-e1590109152979.jpg', 'Medic', 'Katarina', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'psiholog2');


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
INSERT INTO user_workshops(
	is_canceled,user_id, workshop_id)
	VALUES (false, 4, 1);
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

INSERT INTO workshop_tests(
	needed_points, workshop_id, name)
	VALUES (80, 1, 'Test about understending anxiety: Tools to Regain Control');

INSERT INTO workshop_tests_q(
	points_per_question, test_id, text)
	VALUES ( 10, 1, 'What is anxiety?');
INSERT INTO workshop_tests_q(
	points_per_question, test_id, text)
	VALUES ( 15, 1, 'What is the most common symptom of anxiety?');
INSERT INTO workshop_tests_q(
	points_per_question, test_id, text)
	VALUES ( 15, 1, 'Which tool is most commonly used for self-help with anxiety?');
INSERT INTO workshop_tests_q(
	points_per_question, test_id, text)
	VALUES ( 10, 1, 'How does exercise affect anxiety?');
INSERT INTO workshop_tests_q(
	points_per_question, test_id, text)
	VALUES ( 15, 1, 'What is a recommended technique for immediate anxiety control?');

INSERT INTO workshop_tests_q(
	points_per_question, test_id, text)
	VALUES ( 15, 1, 'What is cognitive-behavioral therapy (CBT)?');


INSERT INTO workshop_tests_a(is_true, question_id, text)
	VALUES (false,1, ' Anxiety is a state of constant sadness and depression.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (true,1, ' Anxiety is a natural response of the body to stress.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (false,1, '  Anxiety is purely a physical condition with no emotional symptoms.');

INSERT INTO workshop_tests_a(is_true, question_id, text)
	VALUES (false,2, 'Memory loss.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (true,2, 'Excessive sweating.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (false,2, 'Changes in vision.');

INSERT INTO workshop_tests_a(is_true, question_id, text)
	VALUES (true,3, 'Breathing exercises.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (false,3, 'Talking about it.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (false,3, 'Consuming caffeine.');

INSERT INTO workshop_tests_a(is_true, question_id, text)
	VALUES (true,4, 'Can reduce anxiety symptoms and improve mood.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (false,4, 'Does not affect anxiety in any way.');

INSERT INTO workshop_tests_a(is_true, question_id, text)
	VALUES (true,5, 'Focused breathing.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (false,5, ' Intense exercise.');
    INSERT INTO workshop_tests_a(is_true, question_id, text)
        VALUES (false,5, ' Overeating.');

INSERT INTO workshop_tests_a(is_true, question_id, text)
	VALUES (false,6, ' Therapy that deals exclusively with physical symptoms.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
    VALUES (true,6, ' Therapy that helps change negative thought patterns.');
INSERT INTO workshop_tests_a(is_true, question_id, text)
        VALUES (false,6, ' Therapy based on hypnosis.');

INSERT INTO feedbacks_workshop(
	final_grade, recommended, content_grade, organization_grade, price_grade, psychologist_grade, user_id, workshop_id, comment)
	VALUES (4.25, true, 4,5,3,5, 4, 1, 'Sve osim cene mi se dopalo!');
INSERT INTO feedbacks_workshop(
	final_grade, recommended, content_grade, organization_grade, price_grade, psychologist_grade, user_id, workshop_id, comment)
	VALUES (3.5, false, 4,3,2,5, 2, 1, 'Psiholog i materijali su bili losi!');
INSERT INTO feedbacks_workshop(
	final_grade, recommended, content_grade, organization_grade, price_grade, psychologist_grade, user_id, workshop_id, comment)
	VALUES (4.75, true, 5,5,4,5, 3, 1, 'Odlicna!');