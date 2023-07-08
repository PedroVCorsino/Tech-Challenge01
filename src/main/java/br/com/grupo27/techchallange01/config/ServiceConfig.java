package br.com.grupo27.techchallange01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.PedidoRepositoryAdapter;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.PedidoJPA;
import br.com.grupo27.techchallange01.config.mappers.PedidoMapper;
import br.com.grupo27.techchallange01.core.application.clients.PagamentosClientImpl;
import br.com.grupo27.techchallange01.core.application.services.AcompanhamentoServiceImpl;
import br.com.grupo27.techchallange01.core.application.services.BebidaServiceImpl;
import br.com.grupo27.techchallange01.core.application.services.ClienteServiceImpl;
import br.com.grupo27.techchallange01.core.application.services.LancheServiceImpl;
import br.com.grupo27.techchallange01.core.application.services.PedidoServiceImpl;
import br.com.grupo27.techchallange01.core.application.services.ProdutoServiceImpl;
import br.com.grupo27.techchallange01.core.application.services.SobremesaServiceImpl;
import br.com.grupo27.techchallange01.core.domain.ports.client.PagamentosClient;
import br.com.grupo27.techchallange01.core.domain.ports.repository.AcompanhamentoRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.BebidaRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.ClienteRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.LancheRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.repository.SobremesaRepositoryPort;

@Configuration
public class ServiceConfig {

    @Bean
    public PedidoServiceImpl pedidoService(PedidoJPA pedidoJPA, PedidoMapper pedidoMapper, PagamentosClient pagamentosClient) {
        return new PedidoServiceImpl(new PedidoRepositoryAdapter(pedidoJPA, pedidoMapper), pedidoMapper, pagamentosClient);
    }

    @Bean
    public PagamentosClient pagamentosClient(WebClient.Builder webClientBuilder) {
        return new PagamentosClientImpl(webClientBuilder);
    }

    @Bean
    public ClienteServiceImpl clienteService(ClienteRepositoryPort clienteRepository) {
        return new ClienteServiceImpl(clienteRepository);
    }

    // Produtos
    @Bean
    public ProdutoServiceImpl produtoService(LancheRepositoryPort lancheRepository,
                                             AcompanhamentoRepositoryPort acompanhamentoRepository,
                                             BebidaRepositoryPort bebidaRepository,
                                             SobremesaRepositoryPort sobremesaRepository) {
        return new ProdutoServiceImpl(lancheRepository, acompanhamentoRepository, bebidaRepository, sobremesaRepository);
    }

    @Bean
    public LancheServiceImpl lancheService(LancheRepositoryPort lancheRepository) {
        return new LancheServiceImpl(lancheRepository);
    }

    @Bean
    public AcompanhamentoServiceImpl acompanhamentoService(AcompanhamentoRepositoryPort acompanhamentoRepository) {
        return new AcompanhamentoServiceImpl(acompanhamentoRepository);
    }
    
    @Bean
    public BebidaServiceImpl bebidaService(BebidaRepositoryPort bebidaRepository) {
        return new BebidaServiceImpl(bebidaRepository);
    }

    @Bean
    public SobremesaServiceImpl sobremesaService(SobremesaRepositoryPort sobremesaRepository) {
        return new SobremesaServiceImpl(sobremesaRepository);
    }

    
}
