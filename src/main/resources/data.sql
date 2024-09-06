-- ข้อมูลเริ่มต้นสำหรับตาราง `movies`
INSERT INTO movies (id, title, genre, release_date) VALUES
(1, 'Inception', 'Science Fiction', '2010-07-16'),
(2, 'The Matrix', 'Action', '1999-03-31'),
(3, 'The Shawshank Redemption', 'Drama', '1994-09-23');

-- ข้อมูลเริ่มต้นสำหรับตาราง `users`
INSERT INTO users (id, username, email, password) VALUES
(1, 'john_doe', 'john.doe@example.com', 'password123'),
(2, 'jane_smith', 'jane.smith@example.com', 'password456');

-- ข้อมูลเริ่มต้นสำหรับตาราง `reviews`
INSERT INTO reviews (id, movie_id, user_id, rating, comment) VALUES
(1, 1, 1, 5, 'Amazing movie with a mind-bending plot!'),
(2, 2, 2, 4, 'Great action scenes and an intriguing story.');

-- ข้อมูลเริ่มต้นสำหรับตาราง `comments`
INSERT INTO comments (id, review_id, user_id, content) VALUES
(1, 1, 2, 'I totally agree with your review!'),
(2, 2, 1, 'The action sequences were indeed fantastic.');

-- ข้อมูลเริ่มต้นสำหรับตาราง `genres`
INSERT INTO genres (id, name) VALUES
(1, 'Science Fiction'),
(2, 'Action'),
(3, 'Drama');
