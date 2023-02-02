BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'TAAifFP590', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', '5H5JS0KLzK', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'RLlDWHh7hR', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'fDn9rQjH9O', 'played');

COMMIT TRANSACTION;
