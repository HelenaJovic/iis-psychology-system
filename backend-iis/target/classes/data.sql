INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
    role_id, email, last_name, name, password, username, image_url)
VALUES (2, 'admin@gmail.com', 'Peric', 'Sasa', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');


INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'zarkokn@gmail.com', 'Markovic', 'Marija', '$2y$10$HgilFq.14RicLfcPGKBOYeuplIU.wTz1NbYeSuY5fblX4TWkUj8UW', 'student1', 'https://themarketingcrowd.ie/wp-content/uploads/2017/01/Round-Profile-Pic.png');

INSERT INTO student(id, faculty_name)
VALUES (2, 'Psiholoski fakultet NS');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student2@gmail.com', 'Boskovic', 'Marko', '$2y$10$XeHBUEM6tbR2LFj8VaBuz.yv1QSdn8X0vVidt/3Yais4mA8oBLyT2', 'student2', 'https://oliver-andersen.se/wp-content/uploads/2018/03/cropped-Profile-Picture-Round-Color.png');

INSERT INTO student(id, faculty_name)
VALUES (3, 'Privatni psiholoski fakultet BG');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student3@gmail.com', 'Savic', 'Mihailo', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student3', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student4@gmail.com', 'Peric', 'Sara', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student4', 'https://static.vecteezy.com/system/resources/thumbnails/026/540/471/small_2x/portrait-of-a-beautiful-young-woman-isolated-png.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student5@gmail.com', 'Krstic', 'Sava', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student5', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student6@gmail.com', 'Jovic', 'Jova', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student6', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student7@gmail.com', 'Peric', 'Miona', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student7', 'https://img.freepik.com/free-psd/studio-portrait-young-teenage-girl_23-2150162484.jpg');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student8@gmail.com', 'Knezevic', 'Jana', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student8', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student9@gmail.com', 'Peric', 'Petra', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student9', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student10@gmail.com', 'Lazic', 'Aleksandar', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student10', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student11@gmail.com', 'Mitrovic', 'Jana', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student11', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student12@gmail.com', 'Lukic', 'Lea', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student12', 'https://i.imgur.com/r0bsDqL.png');

INSERT INTO student(id, faculty_name)
VALUES (4, 'Psiholoski fakultet EDUCONS');

INSERT INTO student(id, faculty_name)
VALUES (5, 'Psiholoski fakultet NIS');

INSERT INTO student(id, faculty_name)
VALUES (6, 'Filozofski fakultet');

INSERT INTO student(id, faculty_name)
VALUES (7, 'Psiholoski fakultet NIS');

INSERT INTO student(id, faculty_name)
VALUES (8, 'Psiholoski fakultet NS');

INSERT INTO student(id, faculty_name)
VALUES (9, 'Psiholoski fakultet NIS');

INSERT INTO student(id, faculty_name)
VALUES (10, 'Filozofski fakultet');

INSERT INTO student(id, faculty_name)
VALUES (11, 'Psiholoski fakultet NIS');

INSERT INTO student(id, faculty_name)
VALUES (12, 'Psiholoski fakultet NS');


INSERT INTO hall (name, capacity)
VALUES ('Hall A', 80);

INSERT INTO hall (name, capacity)
VALUES ('Hall B', 60);

INSERT INTO hall (name, capacity)
VALUES ('Hall 101', 40);

INSERT INTO hall (name, capacity)
VALUES ('Lab 203', 30);

INSERT INTO internship (title, date, category, image_url)
VALUES ('Extra Psychology Internship', '2024-09-15', 1, 'https://www.myconsultingoffer.org/wp-content/uploads/Consulting-Internship.png');

INSERT INTO internship (title, date, category, image_url)
VALUES ('Modern Psychology Internship', '2024-10-20', 2, 'https://www.usatoday.com/gcdn/-mm-/db4d91ab7b5a4bd4f81da93a6d7056902c8c6aa1/c=0-473-7904-4939/local/-/media/2018/06/20/USATODAY/USATODAY/636651170533306247-intern-1.jpg');

INSERT INTO internship (title, date, category, image_url)
VALUES ('Advanced Mental Health Internship', '2024-11-10', 0, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLpsMTqjWU13MuWNPT1JwL9yDWIHejDu_24g&s');

INSERT INTO internship (title, date, category, image_url)
VALUES ('Rehabilitation and Counseling Internship', '2025-02-05', 1, 'https://assets-global.website-files.com/6527fd1691c6b050ff920c18/653637e2851558e8d2eff5b3_The%204%20Benefits%20an%20Internship%20Program%20Can%20Bring%20to%20Your%20Business.webp');

INSERT INTO internship (title, date, category, image_url)
VALUES ('Child and Adolescent Psychology Program', '2024-12-20', 3, 'https://assets.entrepreneur.com/content/3x2/2000/20150503125436-shutterstock-177305711.jpeg');

INSERT INTO internship (title, date, category, image_url)
VALUES ('Trauma counseling', '2024-09-25', 3, 'https://www.naceweb.org/images/default-source/2019/feature/allowing-students-to-use-jobs-as-internships-xlarge.jpg');

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (false, 100, '2024-09-20', null, 1);

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (true, 100, '2023-10-25', '10:00:00', 2);

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (true, 100, '2022-09-20', null, 3);

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (true, 100, '2024-11-05', '12:00:00', 4);

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (true, 100, '2024-09-23', '12:00:00', 5);

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (true, 100, '2025-02-20', null, 6);


INSERT INTO hall_reservation (date, duration, time, hall_id, internship_test_id)
VALUES  ('2024-09-20', 3, '11:00:00', 1, 2);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (2, 1, 65, true);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (3, 1, 20, true);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (4, 1, 75, true);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (2, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (3, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (5, 1, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (6, 1, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (7, 1, 20, true);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (8, 1, 0, false);



INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (9, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (10, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (11, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (12, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (8, 2, 0, false);

INSERT INTO users(
    role_id, email, last_name, name, password, username, image_url)
VALUES (5, 'menadzer@gmail.com', 'Lazic', 'Ana', '$2y$10$tQTm6Mf6G93ftNmf.NuFb.37OwqSRAII9bqgvIOaU3P45SxxgOrFO', 'menadzer', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (4, 'psiholog@gmail.com', 'Knezevic', 'Zarko', '$2a$12$gjNONuZTM43S47DRK21c1ugkw1sUQS1OiXMFsOkiOHaZ/HsmGe6fu', 'psiholog', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');

INSERT INTO psychologist(id, biography)
VALUES (1, 'skolovani psiholog spreman na sve');

INSERT INTO student_internship(internship_id, psychologist_id, student_id, end_date)
VALUES (2, 1, 2, '2024-07-25');

INSERT INTO student_internship(internship_id, psychologist_id, student_id, end_date)
VALUES (2, 1, 3, '2024-06-10');

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (1, 'Adolescent Assessment Assistance', 'Assist in administering psychological assessments to adolescents, including scoring and report compilation.', 3, 1);

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (1, 'Child Development Observation', 'Conduct observational research on child development, including participant recruitment and data analysis.', 1, 2);

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (1, 'Mental Health Awareness Workshops', 'Assist in providing psychoeducation workshops on mental health, including content development and facilitation.', 0, 2);

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (1, 'Parenting Skills Workshop Development', ' Develop workshops on parenting skills, covering topics such as communication and discipline techniques.', 1, 1);

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (2, 'Child Development Observation', 'Conduct observational research on child development, including participant recruitment and data analysis.', 1, 2);

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (2, 'New Psychology Internship', 'Assist in providing psychoeducation workshops on mental health, including content development and facilitation.', 2, 2);

INSERT INTO task(student_internship_id, title, description, status, priority)
VALUES (2, 'Parenting Skills Workshop Development', ' Develop workshops on parenting skills, covering topics such as communication and discipline techniques.', 1, 1);

INSERT INTO message (student_id, psychologist_id, student_internship_id, content, is_read, sender)
VALUES (2, 1, 1, 'I have one question', true, 'student');

INSERT INTO message (student_id, psychologist_id, student_internship_id, content, is_read, sender)
VALUES (2, 1, 1, 'I am here, how can i help you?', true, 'psychologist');

INSERT INTO message (student_id, psychologist_id, student_internship_id, content, is_read, sender)
VALUES (2, 1, 1, 'Task about mental health is little confusing', false, 'student');

INSERT INTO message (student_id, psychologist_id, student_internship_id, content, is_read, sender)
VALUES (2, 1, 1, 'I am not sure what should I do', false, 'student');