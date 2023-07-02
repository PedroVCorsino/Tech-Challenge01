package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.model.Bebida;

public record BebidaDTO(Long id, String nome, String descricao, BigDecimal preco) {
    public Bebida toBebida() {
        return new Bebida(this.id, this.nome, this.descricao, this.preco);
    }
}
