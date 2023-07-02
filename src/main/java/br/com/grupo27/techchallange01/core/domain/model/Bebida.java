package br.com.grupo27.techchallange01.core.domain.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.BebidaEntity;
import br.com.grupo27.techchallange01.core.application.dto.BebidaDTO;
import br.com.grupo27.techchallange01.core.domain.model.abstractions.Produto;
public class Bebida extends Produto {
    public Bebida(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public BebidaDTO toDTO() {
        return new BebidaDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

    public BebidaEntity toEntity() {
        return new BebidaEntity(this.getNome(), this.getDescricao(), this.getPreco());
    }
    
}

