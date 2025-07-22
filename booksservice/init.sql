CREATE TABLE IF NOT EXISTS book_editions (
	id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	title varchar(100) NOT NULL,
	author varchar(100) NOT NULL,
	isbn char(17) NOT NULL UNIQUE
);
