SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `teacher`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course_student`;
DROP TABLE IF EXISTS `class`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `teacher` (
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`name`, `email`)
);

CREATE TABLE `course` (
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `class_id` INTEGER NOT NULL,
    `teacher_id` INTEGER NOT NULL,
    `create_date` DATE NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`title`)
);

CREATE TABLE `student` (
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`name`, `email`)
);

CREATE TABLE `course_student` (
    `course_id` INTEGER NOT NULL,
    `student_id` INTEGER NOT NULL,
    `vize_not` INTEGER,
    `final_not` INTEGER,
    `ortalama` INTEGER,
    PRIMARY KEY (`course_id`, `student_id`)
);

CREATE TABLE `class` (
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `size` INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`name`)
);

ALTER TABLE `course` ADD FOREIGN KEY (`class_id`) REFERENCES `class`(`id`);
ALTER TABLE `course` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teacher`(`id`);
ALTER TABLE `course_student` ADD FOREIGN KEY (`course_id`) REFERENCES `course`(`id`);
ALTER TABLE `course_student` ADD FOREIGN KEY (`student_id`) REFERENCES `student`(`id`);