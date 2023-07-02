package br.com.grupo27.techchallange01.adapter.driver.api.controllers.produtos;

import br.com.grupo27.techchallange01.core.application.dto.ProdutoDTO;
import br.com.grupo27.techchallange01.core.domain.ports.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

    private final ProdutoService produtoService;

    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<ProdutoDTO> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosByTipo(@PathVariable String tipo) {
        List<ProdutoDTO> produtos = produtoService.getProdutosByTipo(tipo);
        return ResponseEntity.ok(produtos);
    }
}
