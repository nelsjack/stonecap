--TODO remove from release
BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','$2a$10$LSu77d.VEe4sNbVuo00MTuxozqvFdFQYzaSx4mImcNnVErHpB7Mnm','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','$2a$10$9pLqNb.VJjyFF0Slh7lF/Oh36b1AO730phG6qRwqHcL5kpz2RmF3a','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','$2a$10$HuH19ioVrKFtJenqVDZTwuNS2Nr2Vc33WZALPE.PoBIbDDGeaYrtO','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user4','$2a$10$9pLqNb.VJjyFF0Slh7lF/Oh36b1AO730phG6qRwqHcL5kpz2RmF3a','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user5','$2a$10$HuH19ioVrKFtJenqVDZTwuNS2Nr2Vc33WZALPE.PoBIbDDGeaYrtO','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user6','$2a$10$9pLqNb.VJjyFF0Slh7lF/Oh36b1AO730phG6qRwqHcL5kpz2RmF3a','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$10$HuH19ioVrKFtJenqVDZTwuNS2Nr2Vc33WZALPE.PoBIbDDGeaYrtO','ROLE_ADMIN');

INSERT INTO boardgames (user_id,board_game_id,save_type) VALUES ('3','TAAifFP590','wishlist');
INSERT INTO boardgames (user_id,board_game_id,save_type) VALUES ('3','VNBC6yq1WO','wishlist');
INSERT INTO boardgames (user_id,board_game_id,save_type) VALUES ('3','5H5JS0KLzK','played');
INSERT INTO boardgames (user_id,board_game_id,save_type) VALUES ('3','fDn9rQjH9O','played');
INSERT INTO boardgames (user_id,board_game_id,save_type) VALUES ('3','3IPVIROfvl','owned');
INSERT INTO boardgames (user_id,board_game_id,save_type) VALUES ('3','E4ELA8cG85','owned');

COMMIT TRANSACTION;
