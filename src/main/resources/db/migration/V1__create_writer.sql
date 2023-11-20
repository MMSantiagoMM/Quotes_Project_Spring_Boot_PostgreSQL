CREATE TABLE "Writers"(
id SERIAL NOT NULL PRIMARY KEY,
name VARCHAR (100),
nationality VARCHAR (100),
isAlive BOOLEAN,
century VARCHAR (3)
);