CREATE TABLE IF NOT EXISTS cliente (
  id SERIAL PRIMARY KEY,
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL
);


-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('12345678901', 'João da Silva', 'joao@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('98765432109', 'Maria Souza', 'maria@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('45678912345', 'Pedro Oliveira', 'pedro@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('78901234567', 'Ana Santos', 'ana@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('23456789012', 'Lucas Pereira', 'lucas@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('56789012345', 'Mariana Fernandes', 'mariana@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('90123456789', 'Rafaela Costa', 'rafaela@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('34567890123', 'Carlos Rodrigues', 'carlos@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('67890123456', 'Juliana Almeida', 'juliana@example.com');
-- INSERT INTO CLIENTE (cpf, nome, email) VALUES ('01234567890', 'Gustavo Santos', 'gustavo@example.com');
