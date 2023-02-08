BEGIN TRANSACTION;

--Add users
INSERT INTO users (username,password_hash,role,image) VALUES ('user1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/8138/avatar.svg');
INSERT INTO users (username,password_hash,role,image)VALUES ('user2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/106359/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('kim','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/7225/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('rob','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/35097/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('sally','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','https://www.svgrepo.com/show/29895/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('manda','$2a$10$YG4voPSf.dazBbKqyrGaeOnEFeRbpPfKSoXpkM36h1JMPY0zWaBoe','ROLE_USER', 'https://www.svgrepo.com/show/499972/simulator-2.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('jack','$2a$10$1Q5FQEYyYFxMvRUYrHiaJ.nhe9UjQ0Fykx4/XjDc6PtBGd3HHHLB.','ROLE_USER', 'https://www.svgrepo.com/show/499971/casual-placement.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('ahmad','$2a$10$HEetAoX.MqTyoqWpQgIybuvfuest8gvvUiiDPJPIMxfTf8xwQwL4K','ROLE_USER', 'https://www.svgrepo.com/show/499965/chess.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('nick','$2a$10$.1s26MdaZk/zYXhlB3Bqo.DSiQpF8jpYwfgL1KiSiLUiQ.lLuvxOK','ROLE_USER', 'https://www.svgrepo.com/show/499955/card.svg');

--Fill Boardgames with played, wishlist and owned
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'TAAifFP590', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', '3IPVIROfvl', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'OIXt3DmJU0', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', '5H5JS0KLzK', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'M7r9tO1GbX', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'RLlDWHh7hR', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'fDn9rQjH9O', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('5', 'TAAifFP590', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('6', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('5', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('4', '3IPVIROfvl', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('3', 'OIXt3DmJU0', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('4', '5H5JS0KLzK', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('5', 'M7r9tO1GbX', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('6', 'RLlDWHh7hR', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('6', 'OIXt3DmJU0', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('6', 'OIXt3DmJU0', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('7', 'GJ94Cl7cz5', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('7', 'fDn9rQjH9O', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('8', 'fDn9rQjH9O', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('8', 'TAAifFP590', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('9', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('9', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('8', '3IPVIROfvl', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('9', 'OIXt3DmJU0', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('8', 'ApSXoXA1Gs', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('9', 'M7r9tO1GbX', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('7', 'RLlDWHh7hR', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('7', 'OIXt3DmJU0', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('6', 'ApSXoXA1Gs', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('8', 'GJ94Cl7cz5', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('9', 'fDn9rQjH9O', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('6', 'ApSXoXA1Gs', 'played');
--Create friends entry
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','2');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('2','1');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','3');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','4');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','5');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('6','7');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('6','8');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('6','9');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('7','8');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('7','9');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('7','6');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('8','6');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('8','9');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('8','7');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('8','8');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('7','1');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('9','8');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('9','6');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('9','7');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','9');
--Create a posts
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('1','https://cf.geekdo-images.com/hyqVOyVvyUAVu3PmlP9scg__imagepage/img/-UKJcRC6XhCjZ7JzC6u7m9JRq88=/fit-in/900x600/filters:no_upscale():strip_icc()/pic2977400.jpg', 'Scythe', 'Complex but core is quite simple. A beautifully made board game', 'beautiful, little intimidating', '4', true);
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('4','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZTjx693pJXjSBi5to0zrLAEO4BstWLqcpHg&usqp=CAU', 'Ticket to Ride', 'This is the best game ever, hours of fun!!', 'ticket to ride, the best', '5', true);
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('6','https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1609841765661?format=webp', 'Parks', 'Lots of fun! The theme of pushing forward and discovering new places!', 'parks, national parks, excellent', '5', true);
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('5','https://d2k4q26owzy373.cloudfront.net/350x350/games/uploaded/1607681966336?format=webp', 'Machi Koro', 'Fast paced dice rolling game. Simple but so much fun', 'Machi Koro, quick', '4', true);
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('7','https://d2k4q26owzy373.cloudfront.net/350x350/games/userfiles/1634269400461-pic5197299.jpg?format=webp', 'Chronicles of Crime', 'Co-op game of criminal investing. It was okay, probably wont play it again.', 'crime, eh', '2', true);




COMMIT TRANSACTION;
