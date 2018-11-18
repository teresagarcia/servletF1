create table IF NOT EXISTS NATIONALITY(
	idNation INT IDENTITY,
	name varchar(25),
	PRIMARY KEY(idNation)
);

create table IF NOT EXISTS TEAM(
	idTeam INT IDENTITY,
	name varchar(50),
	nationality INT,
	PRIMARY KEY(idTeam),
	FOREIGN KEY(nationality) references  NATIONALITY(idNation)
);


create table IF NOT EXISTS DRIVER(
	idDriver INT IDENTITY,
	name varchar(25),
	lastName varchar(25),
	team int,
	birthDate date,
	nationality int,
	PRIMARY KEY(idDriver),
	FOREIGN KEY(team) REFERENCES TEAM(idTeam),
	FOREIGN KEY(nationality) REFERENCES NATIONALITY(idNation)
);

