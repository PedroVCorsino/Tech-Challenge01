package br.com.grupo27.techchallange01.core.domain.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.AcompanhamentoEntity;
import br.com.grupo27.techchallange01.core.application.dto.AcompanhamentoDTO;
import br.com.grupo27.techchallange01.core.domain.model.abstractions.Produto;

public class Acompanhamento extends Produto {
    public Acompanhamento(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public AcompanhamentoDTO toDTO() {
        return new AcompanhamentoDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

    public AcompanhamentoEntity toEntity() {
        return new AcompanhamentoEntity(this.getNome(), this.getDescricao(), this.getPreco());
    }
}
