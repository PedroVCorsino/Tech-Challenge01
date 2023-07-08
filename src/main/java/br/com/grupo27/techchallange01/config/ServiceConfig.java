package br.com.grupo27.techchallange01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.PedidoRepositoryAdapter;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.PedidoJPA;
import br.com.grupo27.techchallange01.config.mappers.PedidoMapper;
import br.com.grupo27.techchallange01.core.application.clients.PagamentosClientImpl;
import br.com.grupo27.techchallange01.core.application.services.PedidoServiceImpl;
import br.com.grupo27.techchallange01.core.domain.ports.client.PagamentosClient;

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

}
