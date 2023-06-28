package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;

public record ProdutoDTO(
    Long id,
    String nome,
    String descricao,
    BigDecimal preco
) {
    
}
