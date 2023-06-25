package br.com.grupo27.techchallange01.core.application.dto;

import br.com.grupo27.techchallange01.core.domain.entities.CategoriaProduto;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.CPF;

public record ProdutoDTO(Long id, String nome, CategoriaProduto categoriaProduto) {
}
