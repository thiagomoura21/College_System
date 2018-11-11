---------------
---CREATE SYSTEM

CREATE DATABASE COLLEGE_SYSTEM;
USE COLLEGE_SYSTEM;

CREATE TABLE TB_STUDENT(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(255),
ADDRESS VARCHAR(255),
NATIONALITY VARCHAR(128),
ID_COURSE BIGINT
);

CREATE TABLE TB_LOGIN_STUDENT(
ID BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
NAME_LOGIN VARCHAR(255),
PASSWORD VARCHAR(255)
);

CREATE TABLE TB_LOGIN_ADMIN(
NAME_LOGIN VARCHAR(255),
PASSWORD VARCHAR(255)
);

CREATE TABLE TB_COURSE(
ID BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
NAME VARCHAR(255)
);

ALTER TABLE TB_STUDENT ADD CONSTRAINT STUDENT_MATRICULATE
FOREIGN KEY (ID_COURSE) REFERENCES TB_COURSE(ID);

ALTER TABLE TB_LOGIN_STUDENT ADD CONSTRAINT STUDENT_LOGIN
FOREIGN KEY (ID) REFERENCES TB_STUDENT(ID);

---------------
---DROP SYSTEM

ALTER TABLE TB_STUDENT
DROP CONSTRAINT STUDENT_MATRICULATE;

ALTER TABLE TB_LOGIN_STUDENT
DROP CONSTRAINT STUDENT_LOGIN;

DROP TABLE TB_STUDENT;

DROP TABLE TB_LOGIN_STUDENT;

DROP TABLE TB_LOGIN_ADMIN;

DROP DATABASE COLLEGE_SYSTEM;




