package br.com.grupo27.techchallange01.core.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.PedidoRepositoryAdapter;
import br.com.grupo27.techchallange01.config.mappers.PedidoMapper;
import br.com.grupo27.techchallange01.core.application.dto.PedidoDTO;
import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;
import br.com.grupo27.techchallange01.core.domain.ports.client.PagamentosClient;
import br.com.grupo27.techchallange01.core.domain.ports.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepositoryAdapter PedidoAdapter;
    private final PedidoMapper PedidoMapper;
    private final PagamentosClient PagamentosClient;
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

    public PedidoServiceImpl(PedidoRepositoryAdapter pedidoAdapter,
        PedidoMapper pedidoMapper, PagamentosClient pagamentosClient) {
        this.PedidoAdapter = pedidoAdapter;
        this.PedidoMapper = pedidoMapper;
        this.PagamentosClient = pagamentosClient;
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
    
    @Override
    public boolean consultaStatusPagamento(Long id) {
        return PagamentosClient.consultaStatusPagamento(id);
    }

    @Override
    public PedidoDTO verificaStatusPagamento(Long id) {
        Pedido pedido = PedidoAdapter.findPedidoById(id);

        if (pedido == null) {
            throw new RuntimeException("Pedido não encontrado");
        }

        if (pedido.isPago()) {
            return PedidoMapper.domainToDto(pedido);
        }

        boolean isPago = consultaStatusPagamento(id);

        if (isPago) {
            pedido.setPago(true);
            Pedido updatedPedido = PedidoAdapter.updatePedido(id, pedido);
            return PedidoMapper.domainToDto(updatedPedido);
        } else {
            throw new RuntimeException("Pedido não pago");
        }
    }

    @Override
    public List<PedidoDTO> findPedidosByStatusPagamento(boolean pago) {
        List<Pedido> pedidos = PedidoAdapter.findPedidosByStatusPagamento(pago);
        return pedidos.stream().map(PedidoMapper::domainToDto).collect(Collectors.toList());
    }
    
    @Override
    public List<Pedido> findPedidosByStatus(StatusPedido status) {
        return PedidoAdapter.findPedidosByStatus(status);
    }
}
