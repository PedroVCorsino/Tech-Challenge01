package br.com.grupo27.techchallange01.core.domain.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.SobremesaEntity;
import br.com.grupo27.techchallange01.core.application.dto.SobremesaDTO;
import br.com.grupo27.techchallange01.core.domain.model.abstractions.Produto;
public class Sobremesa extends Produto {
    public Sobremesa(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public SobremesaDTO toDTO() {
        return new SobremesaDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

        public SobremesaEntity toEntity() {
        return new SobremesaEntity(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
 
}

