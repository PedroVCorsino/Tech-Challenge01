package br.com.grupo27.techchallange01.core.application.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.PedidoRepositoryAdapter;
import br.com.grupo27.techchallange01.config.mappers.PedidoMapper;
import br.com.grupo27.techchallange01.core.application.dto.PedidoDTO;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;
import br.com.grupo27.techchallange01.core.domain.ports.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepositoryAdapter PedidoAdapter;
    private final PedidoMapper PedidoMapper;

    public PedidoServiceImpl(PedidoRepositoryAdapter pedidoAdapter, PedidoMapper pedidoMapper) {
        this.PedidoAdapter = pedidoAdapter;
        this.PedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoDTO getPedidoById(Long id) {
        Pedido pedido = PedidoAdapter.findPedidoById(id);
        return PedidoMapper.domainToDto(pedido);
    }

    @Override
    public List<PedidoDTO> getAllPedidos() {
        List<Pedido> pedidos = PedidoAdapter.findAllPedidos();
        return pedidos.stream().map(PedidoMapper::domainToDto).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoMapper.dtoToDomain(pedidoDTO);
        Pedido createdPedido = PedidoAdapter.createPedido(pedido);
        return PedidoMapper.domainToDto(createdPedido);
    }

    @Override
    public PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoMapper.dtoToDomain(pedidoDTO);
        Pedido updatedPedido = PedidoAdapter.updatePedido(id, pedido);
        return PedidoMapper.domainToDto(updatedPedido);
    }

    @Override
    public boolean deletePedido(Long id) {
        return PedidoAdapter.deletePedido(id);
    }
    
}
