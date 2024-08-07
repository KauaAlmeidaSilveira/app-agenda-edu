INSERT INTO tb_user (email, name, password, role) VALUES ('kaua@gmail.com', 'Kauã Almeida', '$2a$10$enPY3JfMQZEb3cF7mznk.OoQa7V0sq6uvSxnm7MlFclpD5JGVV6Nq', 'ADMIN');
INSERT INTO tb_user (email, name, password, role) VALUES ('joao@gmail.com', 'João Silveira', '$2a$10$idUR/CGA81cx9st3NjBqFuf5VDkHki9fD94b/nXuHSiRbdKju.dnq', 'ADMIN');

INSERT INTO tb_local (name) VALUES ('Sala 101');
INSERT INTO tb_local (name) VALUES ('Sala 102');
INSERT INTO tb_local (name) VALUES ('Sala 103');
INSERT INTO tb_local (name) VALUES ('Laboratório 1');
INSERT INTO tb_local (name) VALUES ('Laboratório 2');
INSERT INTO tb_local (name) VALUES ('Teatro');
INSERT INTO tb_local (name) VALUES ('Auditório');
INSERT INTO tb_local (name) VALUES ('Sala 201');
INSERT INTO tb_local (name) VALUES ('Sala 202');
INSERT INTO tb_local (name) VALUES ('Laboratório 3');


INSERT INTO tb_booking (date, check_in, check_out, course, status, local_id, user_id) VALUES ('2024-08-03', '09:00:00', '12:00:00', 'Maternal', 'ACTIVE', 1, 1);
INSERT INTO tb_booking (date, check_in, check_out, course, status, local_id, user_id) VALUES ('2024-08-03', '12:00:00', '13:00:00', 'Jardim', 'ACTIVE', 1, 1);
INSERT INTO tb_booking (date, check_in, check_out, course, status, local_id, user_id) VALUES ('2024-08-03', '15:00:00', '17:00:00', 'Pré', 'ACTIVE', 1, 1);
INSERT INTO tb_booking (date, check_in, check_out, course, status, local_id, user_id) VALUES ('2024-08-03', '13:00:00', '14:00:00', '1º Ano', 'ACTIVE', 1, 1);
