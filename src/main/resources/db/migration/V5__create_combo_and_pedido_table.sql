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