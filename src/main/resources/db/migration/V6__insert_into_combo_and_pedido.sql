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


