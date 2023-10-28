BEGIN TRANSACTION;
DROP TABLE IF EXISTS "follows";
CREATE TABLE IF NOT EXISTS "follows" (
	"user_id"	INTEGER NOT NULL,
	"follow_user_id"	INTEGER NOT NULL,
	FOREIGN KEY("follow_user_id") REFERENCES "user"("user_id"),
	FOREIGN KEY("user_id") REFERENCES "user"("user_id"),
	PRIMARY KEY("user_id","follow_user_id")
);
DROP TABLE IF EXISTS "post_comment";
CREATE TABLE IF NOT EXISTS "post_comment" (
	"comment_id"	INTEGER NOT NULL UNIQUE,
	"post_id"	INTEGER NOT NULL,
	"comment"	TEXT NOT NULL,
	"user_id"	INTEGER NOT NULL,
	FOREIGN KEY("post_id") REFERENCES "post"("post_id"),
	FOREIGN KEY("user_id") REFERENCES "user"("user_id"),
	PRIMARY KEY("comment_id" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "post_like";
CREATE TABLE IF NOT EXISTS "post_like" (
	"user_id"	INTEGER NOT NULL,
	"post_id"	INTEGER NOT NULL,
	FOREIGN KEY("user_id") REFERENCES "user"("user_id"),
	FOREIGN KEY("post_id") REFERENCES "post"("post_id"),
	PRIMARY KEY("post_id","user_id")
);
DROP TABLE IF EXISTS "user";
CREATE TABLE IF NOT EXISTS "user" (
	"user_id"	INTEGER NOT NULL UNIQUE,
	"pp_url"	TEXT NOT NULL DEFAULT 'default.jpg',
	"name"	TEXT NOT NULL UNIQUE,
	"password"	TEXT NOT NULL,
	PRIMARY KEY("user_id" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "post";
CREATE TABLE IF NOT EXISTS "post" (
	"post_id"	INTEGER NOT NULL UNIQUE,
	"user_id"	INTEGER NOT NULL,
	"title"	TEXT NOT NULL,
	"description"	TEXT,
	"image_url"	TEXT DEFAULT 'default.jpg',
	"timestamp"	TEXT NOT NULL,
	FOREIGN KEY("user_id") REFERENCES "user"("user_id"),
	PRIMARY KEY("post_id" AUTOINCREMENT)
);
COMMIT;
