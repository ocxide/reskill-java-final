CREATE TABLE IF NOT EXISTS borrowings (
	id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	user_id bigint NOT NULL,
	book_copy_id bigint NOT NULL,

	expires_past INTERVAL,
	borrowed_at TIMESTAMP,

	expiration_notified BOOLEAN DEFAULT FALSE
);

