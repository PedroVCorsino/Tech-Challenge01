package br.com.grupo27.techchallange01.core.application.services.interfaces;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.application.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO getProdutoById(Long id);

    List<ProdutoDTO> getAllProdutos();

    ProdutoDTO createProduto(ProdutoDTO produtoDTO);

    ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO);

    boolean deleteProduto(Long id);

}
