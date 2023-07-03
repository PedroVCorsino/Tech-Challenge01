package br.com.grupo27.techchallange01.core.domain.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.model.abstractions.Produto;

public class Lanche extends Produto {
    public Lanche(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

}
