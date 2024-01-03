CREATE DATABASE IF NOT EXISTS swiftlift;
USE swiftlift;

CREATE TABLE IF NOT EXISTS users (
	id INT(12),
    username VARCHAR(20) NOT NULL UNIQUE,
    `name` VARCHAR(20) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY users(id)
);

CREATE TABLE IF NOT EXISTS exercises (
	id INT(12),
    `name` VARCHAR(20) NOT NULL UNIQUE,
    CONSTRAINT pk_exercises PRIMARY KEY exercises(id)
);

CREATE TABLE IF NOT EXISTS users_exercises (
	user_id INT(12),
    exercise_id INT(12),
    CONSTRAINT pk_users_exercises PRIMARY KEY users_exercises(user_id, exercise_id),
    CONSTRAINT fk_users FOREIGN KEY users_exercises(user_id) REFERENCES users(id),
    CONSTRAINT fk_exercises FOREIGN KEY users_exercises(exercise_id) REFERENCES exercises(id)
);

CREATE TABLE IF NOT EXISTS training_session (
	id INT(20),
    heart_rate FLOAT(3,2),
    o2_sat FLOAT(4,2),
    blood_pressure FLOAT(3,2),
    calories INT(5)
);

CREATE TABLE IF NOT EXISTS user_training_session (
	user_id INT(12),
    session_id INT(12),
    CONSTRAINT pk_user_training_session PRIMARY KEY user_training_session(user_id, session_id),
    CONSTRAINT fk_users FOREIGN KEY user_training_session(user_id) REFERENCES users(id),
    CONSTRAINT fk_sessions FOREIGN KEY user_training_session(session_id) REFERENCES training_session(id)
);

CREATE TABLE IF NOT EXISTS `comment` (
	id INT(12),
    content VARCHAR(200) NOT NULL,
    user_id INT(12) NOT NULL,
    `date` DATE NOT NULL,
    CONSTRAINT pk_comment PRIMARY KEY `comment`(id),
    CONSTRAINT fk_user FOREIGN KEY `comment`(user_id) REFERENCES users(id)
);