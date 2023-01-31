BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

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
    boardgame_id varchar(20) NOT NULL,
    save_type varchar(20) NOT NULL,
    CONSTRAINT FK_user FOREIGN KEY (user_id)
);

CREATE TABLE post (
    post_id SERIAL,
    user_id int NOT NULL,
    user_game_id int NOT NULL,
    image varchar (50) NOT NULL,
    title varchar (50) NOT NULL,
    comments varchar (10000) NOT NULL,
    tags varchar (10000) NOT NULL,
    rating int NOT NULL,
    public_private boolean NOT NULL,
    CONSTRAINT PK_post PRIMARY KEY (post_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id),
    CONSTRAINT FK_boardgames FOREIGN KEY (user_game_id)
    );

CREATE TABLE friends (
    friend_id SERIAL,
    user_id int NOT NULL,
    username varchar(50) NOT NULL,
    user_id int NOT NULL,
    username varchar (50) NOT NULL,
    CONSTRAINT PK_friends PRIMARY KEY (friend_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id),
    CONSTRAINT FK_user FOREIGN KEY (username)
);


COMMIT TRANSACTION;
