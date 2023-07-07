package br.com.grupo27.techchallange01.core.application.services;

import br.com.grupo27.techchallange01.core.application.dto.ProdutoDTO;
import br.com.grupo27.techchallange01.core.domain.model.Acompanhamento;
import br.com.grupo27.techchallange01.core.domain.model.Bebida;
import br.com.grupo27.techchallange01.core.domain.model.Lanche;
import br.com.grupo27.techchallange01.core.domain.model.Sobremesa;
import br.com.grupo27.techchallange01.core.domain.ports.repository.AcompanhamentoRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.BebidaRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.LancheRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.SobremesaRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.service.ProdutoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final LancheRepositoryPort lancheRepository;
    private final AcompanhamentoRepositoryPort acompanhamentoRepository;
    private final BebidaRepositoryPort bebidaRepository;
    private final SobremesaRepositoryPort sobremesaRepository;

    public ProdutoServiceImpl(LancheRepositoryPort lancheRepository,
                              AcompanhamentoRepositoryPort acompanhamentoRepository,
                              BebidaRepositoryPort bebidaRepository,
                              SobremesaRepositoryPort sobremesaRepository) {
        this.lancheRepository = lancheRepository;
        this.acompanhamentoRepository = acompanhamentoRepository;
        this.bebidaRepository = bebidaRepository;
        this.sobremesaRepository = sobremesaRepository;
    }

    @Override
    public List<ProdutoDTO> getAllProdutos() {
        List<ProdutoDTO> produtos = lancheRepository.listAllLanches().stream()
                .map(this::convertLancheToDTO)
                .collect(Collectors.toList());
        produtos.addAll(acompanhamentoRepository.listAllAcompanhamentos().stream()
                .map(this::convertAcompanhamentoToDTO)
                .collect(Collectors.toList()));
        produtos.addAll(bebidaRepository.listAllBebidas().stream()
                .map(this::convertBebidaToDTO)
                .collect(Collectors.toList()));
        produtos.addAll(sobremesaRepository.listAllSobremesas().stream()
                .map(this::convertSobremesaToDTO)
                .collect(Collectors.toList()));
        return produtos;
    }

    @Override
    public List<ProdutoDTO> getProdutosByTipo(String tipo) {
        List<ProdutoDTO> produtos = null;
        switch (tipo.toLowerCase()) {
            case "lanche":
                produtos = lancheRepository.listAllLanches().stream()
                        .map(this::convertLancheToDTO)
                        .collect(Collectors.toList());
                break;
            case "acompanhamento":
                produtos = acompanhamentoRepository.listAllAcompanhamentos().stream()
                        .map(this::convertAcompanhamentoToDTO)
                        .collect(Collectors.toList());
                break;
            case "bebida":
                produtos = bebidaRepository.listAllBebidas().stream()
                        .map(this::convertBebidaToDTO)
                        .collect(Collectors.toList());
                break;
            case "sobremesa":
                produtos = sobremesaRepository.listAllSobremesas().stream()
                        .map(this::convertSobremesaToDTO)
                        .collect(Collectors.toList());
                break;
        }
        return produtos;
    }

    private ProdutoDTO convertLancheToDTO(Lanche lanche) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(lanche.getId());
        produtoDTO.setNome(lanche.getNome());
        produtoDTO.setDescricao(lanche.getDescricao());
        produtoDTO.setPreco(lanche.getPreco());
        produtoDTO.setTipo("Lanche");
        return produtoDTO;
    }

    private ProdutoDTO convertAcompanhamentoToDTO(Acompanhamento acompanhamento) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(acompanhamento.getId());
        produtoDTO.setNome(acompanhamento.getNome());
        produtoDTO.setDescricao(acompanhamento.getDescricao());
        produtoDTO.setPreco(acompanhamento.getPreco());
        produtoDTO.setTipo("Acompanhamento");
        return produtoDTO;
    }

    private ProdutoDTO convertBebidaToDTO(Bebida bebida) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(bebida.getId());
        produtoDTO.setNome(bebida.getNome());
        produtoDTO.setDescricao(bebida.getDescricao());
        produtoDTO.setPreco(bebida.getPreco());
        produtoDTO.setTipo("Bebida");
        return produtoDTO;
    }

    private ProdutoDTO convertSobremesaToDTO(Sobremesa sobremesa) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(sobremesa.getId());
        produtoDTO.setNome(sobremesa.getNome());
        produtoDTO.setDescricao(sobremesa.getDescricao());
        produtoDTO.setPreco(sobremesa.getPreco());
        produtoDTO.setTipo("Sobremesa");
        return produtoDTO;
    }
}
