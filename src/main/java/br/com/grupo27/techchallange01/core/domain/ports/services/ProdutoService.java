package br.com.grupo27.techchallange01.core.domain.ports.services;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.ProdutoDTO;

public interface ProdutoService {

    ProdutoDTO getProdutoById(Long id);

    List<ProdutoDTO> getAllProdutos();

    ProdutoDTO createProduto(ProdutoDTO produtoDTO);

    ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO);

    boolean deleteProduto(Long id);
    
}
