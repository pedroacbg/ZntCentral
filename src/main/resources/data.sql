INSERT INTO tb_user (nickname, email, password) VALUES ('Gilese', 'gilese@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (nickname, email, password) VALUES ('Junio Logueiro', 'juninlogueiro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (nickname, email, password) VALUES ('João Molenga', 'molenga@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);

INSERT INTO tb_post (text, post_date, user_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse egestas lobortis tortor, in mollis enim. Aliquam erat volutpat. Aliquam erat volutpat. ', TIMESTAMP WITH TIME ZONE '2022-01-15T13:00:00Z', 1);

INSERT INTO tb_reply (text, post_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse egestas lobortis tortor, in mollis enim. Aliquam erat volutpat. Aliquam erat volutpat.', 1);