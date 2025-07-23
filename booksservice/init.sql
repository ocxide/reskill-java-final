CREATE TABLE IF NOT EXISTS book_editions (
	id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	title varchar(100) NOT NULL,
	author varchar(100) NOT NULL,
	isbn char(17) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS book_copies (
	id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	book_edition_id bigint NOT NULL,

	status VARCHAR(20) NOT NULL,
	ingresed_at TIMESTAMP DEFAULT now(),

	FOREIGN KEY (book_edition_id) REFERENCES book_editions(id),
);
