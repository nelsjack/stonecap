BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, boardgames, post, friends;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE boardgames (
    user_game_id SERIAL,
    user_id int NOT NULL,
    board_game_id varchar(20) NOT NULL,
    save_type varchar(20) NOT NULL,
	CONSTRAINT PK_boardgames PRIMARY KEY (user_game_id), 
    CONSTRAINT FK_boardgames_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE post (
    post_id SERIAL,
    user_id int NOT NULL,
--    user_game_id int NOT NULL,
    image varchar (1000) NOT NULL,
    title varchar (50) NOT NULL,
    comments varchar (10000) NOT NULL,
    tags varchar (10000) NOT NULL,
    rating int NOT NULL,
    public_private boolean NOT NULL,
    CONSTRAINT PK_post PRIMARY KEY (post_id),
    CONSTRAINT FK_post_users FOREIGN KEY (user_id) REFERENCES users (user_id),
--    CONSTRAINT FK_post_boardgames FOREIGN KEY (user_game_id) REFERENCES boardgames (user_game_id)
    );

CREATE TABLE friends (
    friend_id SERIAL,
    user_id_one int NOT NULL,
    user_id_two int NOT NULL,
    CONSTRAINT PK_friends PRIMARY KEY (friend_id),
    CONSTRAINT FK_users_one FOREIGN KEY (user_id_one) REFERENCES users (user_id), 
	CONSTRAINT FK_users_two FOREIGN KEY (user_id_two) REFERENCES users (user_id)
);


COMMIT TRANSACTION;
