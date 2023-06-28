package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.Sobremesa;

public record SobremesaDTO(Long id, String nome, String descricao, BigDecimal preco) {
    public Sobremesa toSobremesa() {
        return new Sobremesa(this.id, this.nome, this.descricao, this.preco);
    }
}
