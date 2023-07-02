package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.model.Lanche;

public record LancheDTO(Long id, String nome, String descricao, BigDecimal preco) {
    public Lanche toLanche() {
        return new Lanche(this.id, this.nome, this.descricao, this.preco);
    }
}
