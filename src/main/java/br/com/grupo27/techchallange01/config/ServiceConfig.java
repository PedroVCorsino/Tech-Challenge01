package br.com.grupo27.techchallange01.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.PedidoRepositoryAdapter;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.PedidoJPA;
import br.com.grupo27.techchallange01.config.mappers.PedidoMapper;
import br.com.grupo27.techchallange01.core.application.services.PedidoServiceImpl;

@Configuration
public class ServiceConfig {

    // @Bean
    // public LancheServiceImpl lancheService(LancheJPA lancheJPA, LancheMapper lancheMapper) {
    //     return new LancheServiceImpl(new LancheRepositoryAdapter(lancheJPA, lancheMapper), lancheMapper);
    // }

    @Bean
    public PedidoServiceImpl pedidoService(PedidoJPA pedidoJPA, PedidoMapper pedidoMapper) {
        return new PedidoServiceImpl(new PedidoRepositoryAdapter(pedidoJPA, pedidoMapper), pedidoMapper);
    }

}
