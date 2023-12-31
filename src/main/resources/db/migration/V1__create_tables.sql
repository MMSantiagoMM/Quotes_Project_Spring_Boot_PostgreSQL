CREATE TABLE Writers(
id SERIAL NOT NULL PRIMARY KEY,
name VARCHAR (100),
nationality VARCHAR (100),
is_alive BOOLEAN,
century VARCHAR (3)
);

CREATE TABLE Categories(
id SERIAL NOT NULL PRIMARY KEY,
name VARCHAR (100)
);

CREATE TABLE Publishers(
id SERIAL NOT NULL PRIMARY KEY,
name VARCHAR (100),
city VARCHAR (100)
);

CREATE TABLE Books(
id SERIAL NOT NULL PRIMARY KEY,
name VARCHAR (100),
fk_writer BIGINT,
fk_publisher BIGINT,
pag INTEGER,
date_publication DATE
);

CREATE TABLE Quotes(
id SERIAL NOT NULL PRIMARY KEY,
content TEXT,
pag INTEGER,
book_fk BIGINT,
category_fk BIGINT
);