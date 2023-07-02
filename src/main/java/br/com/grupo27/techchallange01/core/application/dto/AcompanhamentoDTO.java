package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.model.Acompanhamento;

public record AcompanhamentoDTO(Long id, String nome, String descricao, BigDecimal preco) {
    public Acompanhamento toAcompanhamento() {
        return new Acompanhamento(this.id, this.nome, this.descricao, this.preco);
    }
    
}