create table IF NOT EXISTS DRIVER(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name varchar(25) PRIMARY KEY,
	lastName varchar(25),
	team int,
	dateOfBirth date,
	nationality int
);