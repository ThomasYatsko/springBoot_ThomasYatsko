DROP TABLE IF exists cats;

CREATE TABLE IF NOT exists cats 
(
       id int auto_increment NOT NULL PRIMARY KEY,
       name varchar(12) NOT NULL,
       type varchar(12) NOT null
);