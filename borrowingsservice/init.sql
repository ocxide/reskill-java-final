CREATE TABLE IF NOT EXISTS borrowings (
	id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	user_id bigint NOT NULL,
	book_copy_id bigint NOT NULL,

	expires_past INTERVAL UNIQUE,
	borrowed_at TIMESTAMP DEFAULT now()
);

