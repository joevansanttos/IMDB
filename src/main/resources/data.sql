INSERT INTO USUARIO(nome, email, senha) VALUES('Joevan', 'joevan@email.com', '$2a$10$aPwBSd7taT2rdTdnvYvZcumgGSV5LoaT6XEIcdN06dtpBq5/6eZgq');

INSERT INTO USUARIO(nome, email, senha) VALUES('Administrador', 'administrador@email.com', '$2a$10$aPwBSd7taT2rdTdnvYvZcumgGSV5LoaT6XEIcdN06dtpBq5/6eZgq');

INSERT INTO PERFIS(id, nome) VALUES(1, 'ROLE_USUARIO');
INSERT INTO PERFIS(id, nome) VALUES(2, 'ROLE_ADMINISTRADOR');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO ATORES(nome) VALUES('Mark Hammil');

INSERT INTO ATORES(nome) VALUES('Daisi Ridley');

INSERT INTO ATORES(nome) VALUES('Zoe Saldana'); 

INSERT INTO ATORES(nome) VALUES('Sam Worthington'); 



INSERT INTO FILMES(diretor, nome, data, genero) VALUES('George Lucas', 'Star Wars New Hope', '18-11-1977',  'Ficcao');

INSERT INTO FILMES(diretor, nome, data, genero) VALUES('James Cameron', 'Avatar', '18-11-2009',  'Ficcao');

INSERT INTO FILMES(diretor, nome, data, genero) VALUES('Lana Wachowski, Lilly Wachowski', 'Matrix', '21-05-1999',  'Ficcao');

INSERT INTO FILMES(diretor, nome, data, genero) VALUES('Andrew Stanton', 'WALL-E', '27-06-2008',  'Infantil');

INSERT INTO FILMES(diretor, nome, data, genero) VALUES('Rian Johnson', 'Star wars last Jedi', '27-06-2017',  'Ficcao');






INSERT INTO VOTOS(data_criacao, valor, filme_id, usuario_id) VALUES('2021-05-05 18:00:00', 3, 1, 1);

INSERT INTO VOTOS(data_criacao, valor, filme_id, usuario_id) VALUES('2021-05-05 18:00:00', 2, 1, 1);

INSERT INTO VOTOS(data_criacao, valor, filme_id, usuario_id) VALUES('2021-05-05 18:00:00', 1, 1, 1);


INSERT INTO FILMES_ATORES(ator_id, filme_id) VALUES(1,1);

INSERT INTO FILMES_ATORES(ator_id, filme_id) VALUES(1,5);

INSERT INTO FILMES_ATORES(ator_id, filme_id) VALUES(2,5);

INSERT INTO FILMES_ATORES(ator_id, filme_id) VALUES(3,2);

INSERT INTO FILMES_ATORES(ator_id, filme_id) VALUES(4,2);
