package br.com.grupo27.techchallange01.core.domain.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.LancheEntity;
import br.com.grupo27.techchallange01.core.application.dto.LancheDTO;
import br.com.grupo27.techchallange01.core.domain.model.abstractions.Produto;

public class Lanche extends Produto {
    public Lanche(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public LancheDTO toDTO() {
        return new LancheDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

    public LancheEntity toEntity() {
        return new LancheEntity(this.getNome(), this.getDescricao(), this.getPreco());
    }

}
