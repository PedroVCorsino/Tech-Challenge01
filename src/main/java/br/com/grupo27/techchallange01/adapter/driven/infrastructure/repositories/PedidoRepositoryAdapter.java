package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.PedidoEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.PedidoJPA;
import br.com.grupo27.techchallange01.config.mappers.PedidoMapper;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;
import br.com.grupo27.techchallange01.core.domain.ports.repository.PedidoRepositoryPort;

@Repository
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJPA pedidoJPA;
    private final PedidoMapper pedidoMapper; // Instância do Mapper

    public PedidoRepositoryAdapter(PedidoJPA pedidoJPA, PedidoMapper pedidoMapper) {
        this.pedidoJPA = pedidoJPA;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public Pedido findPedidoById(Long id) {
        return pedidoJPA.findById(id)
                .map(pedidoMapper::entityToDomain)
                .orElse(null);
    }

    @Override
    public List<Pedido> findAllPedidos() {
        List<PedidoEntity> pedidoEntities = pedidoJPA.findAll();
        return pedidoEntities.stream()
                .map(pedidoMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoMapper.domainToEntity(pedido);
        PedidoEntity savedPedidoEntity = pedidoJPA.save(pedidoEntity);
        return pedidoMapper.entityToDomain(savedPedidoEntity);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoMapper.domainToEntity(pedido);
        PedidoEntity savedPedidoEntity = pedidoJPA.save(pedidoEntity);
        return pedidoMapper.entityToDomain(savedPedidoEntity);
    }

    @Override
    public boolean deletePedido(Long id) {
        pedidoJPA.deleteById(id);
        return true;
    }  
}
