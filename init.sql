CREATE TABLE IF NOT EXISTS cliente (
  id SERIAL PRIMARY KEY,
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL
);

INSERT INTO CLIENTE(cpf, nome, email) VALUES 
('29680987051', 'João Silva', 'joaosilva@example.com'),
('42920370006', 'Maria Oliveira', 'mariaoliveira@example.com'),
('33862037010', 'Carlos Santos', 'carlossantos@example.com'),
('87180165026', 'Ana Ferreira', 'anaferreira@example.com'),
('20518518086', 'Roberto Souza', 'robertosouza@example.com');

CREATE TABLE LANCHE (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE ACOMPANHAMENTO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE BEBIDA (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE SOBREMESA (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL
);

-- Lanches
INSERT INTO Lanche (nome, descricao, preco) VALUES ('Hambúrguer', 'Delicioso hambúrguer artesanal', 10.99);
INSERT INTO Lanche (nome, descricao, preco) VALUES ('Cheeseburguer', 'Hambúrguer com queijo derretido', 12.99);
INSERT INTO Lanche (nome, descricao, preco) VALUES ('X-Bacon', 'Hambúrguer com bacon crocante', 14.99);
INSERT INTO Lanche (nome, descricao, preco) VALUES ('Vegetariano', 'Lanche saudável com ingredientes naturais', 9.99);
INSERT INTO Lanche (nome, descricao, preco) VALUES ('Frango', 'Lanche com suculento frango grelhado', 11.99);

-- -- Acompanhamentos
INSERT INTO Acompanhamento (nome, descricao, preco) VALUES ('Batata Frita', 'Porção de batatas fritas crocantes', 5.99);
INSERT INTO Acompanhamento (nome, descricao, preco) VALUES ('Onion Rings', 'Deliciosos anéis de cebola empanados', 6.99);
INSERT INTO Acompanhamento (nome, descricao, preco) VALUES ('Nuggets', 'Pedacinhos de frango empanados', 7.99);
INSERT INTO Acompanhamento (nome, descricao, preco) VALUES ('Salada Caesar', 'Salada fresca com molho Caesar', 8.99);
INSERT INTO Acompanhamento (nome, descricao, preco) VALUES ('Mandioca Frita', 'Porção de mandioca frita crocante', 4.99);

-- -- Bebidas
INSERT INTO Bebida (nome, descricao, preco) VALUES ('Refrigerante', 'Bebida gaseificada sabor cola', 4.99);
INSERT INTO Bebida (nome, descricao, preco) VALUES ('Suco Natural', 'Suco de frutas frescas', 5.99);
INSERT INTO Bebida (nome, descricao, preco) VALUES ('Água Mineral', 'Água sem gás', 2.99);
INSERT INTO Bebida (nome, descricao, preco) VALUES ('Chá Gelado', 'Chá gelado sabor limão', 3.99);
INSERT INTO Bebida (nome, descricao, preco) VALUES ('Café', 'Café fresco e quente', 2.99);

-- -- Sobremesas
INSERT INTO Sobremesa (nome, descricao, preco) VALUES ('Bolo de Chocolate', 'Delicioso bolo de chocolate', 7.99);
INSERT INTO Sobremesa (nome, descricao, preco) VALUES ('Pudim de Leite', 'Clássico pudim de leite condensado', 6.99);
INSERT INTO Sobremesa (nome, descricao, preco) VALUES ('Sorvete de Morango', 'Sorvete cremoso sabor morango', 5.99);
INSERT INTO Sobremesa (nome, descricao, preco) VALUES ('Mousse de Maracujá', 'Mousse refrescante de maracujá', 4.99);
INSERT INTO Sobremesa (nome, descricao, preco) VALUES ('Torta de Limão', 'Torta doce com recheio de limão', 6.99);

CREATE TABLE PEDIDO (
  id SERIAL PRIMARY KEY,
  id_cliente BIGINT NOT NULL,
  valor_total DECIMAL(10, 2),
  status VARCHAR(20) NOT NULL,
  pago BOOLEAN NOT NULL
);

CREATE TABLE COMBO (
  id SERIAL PRIMARY KEY,
  lanche_id BIGINT,
  acompanhamento_id BIGINT,
  bebida_id BIGINT,
  sobremesa_id BIGINT,
  quantidade INT NOT NULL,
  valor_unitario DECIMAL(10, 2) NOT NULL,
  valor_total DECIMAL(10, 2) NOT NULL,
  pedido_id BIGINT,
  FOREIGN KEY(lanche_id) REFERENCES LANCHE(id),
  FOREIGN KEY(acompanhamento_id) REFERENCES ACOMPANHAMENTO(id),
  FOREIGN KEY(bebida_id) REFERENCES BEBIDA(id),
  FOREIGN KEY(sobremesa_id) REFERENCES SOBREMESA(id),
  FOREIGN KEY(pedido_id) REFERENCES PEDIDO(id)
);
-- Pedidos
INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (1, 23.98, 'PENDENTE', true);
INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (2, 19.99, 'RECEBIDO', true);
INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (3, 14.99, 'EM_PREPARACAO', true);
INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (4, 10.99, 'PRONTO', true);
INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (5, 17.98, 'FINALIZADO', true);

-- Combos
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (1, 2, 3, 4, 1, 23.98, 23.98, 1);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (2, 4, 1, 3, 1, 19.99, 19.99, 2);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (3, 3, 2, 5, 1, 14.99, 14.99, 3);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (4, 5, 3, 2, 1, 10.99, 10.99, 4);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (5, 1, 4, 1, 1, 17.98, 17.98, 5);

-- Pedidos com status pago false para testar fakeCheckout
INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (1, 10.99 + 5.99 + 4.99 + 7.99, 'PENDENTE', false);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (1, 1, 1, 1, 1, 10.99, 10.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (2, 12.99 + 6.99 + 5.99 + 6.99, 'PENDENTE', false);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (2, 2, 2, 2, 1, 12.99, 12.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (3, 14.99 + 7.99 + 2.99 + 5.99, 'PENDENTE', false);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (3, 3, 3, 3, 1, 14.99, 14.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (4, 9.99 + 8.99 + 3.99 + 4.99, 'PENDENTE', false);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (4, 4, 4, 4, 1, 9.99, 9.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago) VALUES (5, 11.99 + 4.99 + 2.99 + 6.99, 'PENDENTE', false);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (5, 5, 5, 5, 1, 11.99, 11.99, currval('pedido_id_seq'));



