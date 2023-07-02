package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.ProdutoDTO;

public interface ProdutoService {
    List<ProdutoDTO> getAllProdutos();

    List<ProdutoDTO> getProdutosByTipo(String tipo);
    
}
