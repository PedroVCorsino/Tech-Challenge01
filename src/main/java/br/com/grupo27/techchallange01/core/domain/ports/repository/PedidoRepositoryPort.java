package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;

public interface PedidoRepositoryPort {

    Pedido findPedidoById(Long id);

    List<Pedido> findAllPedidos();

    Pedido createPedido(Pedido pedido);

    Pedido updatePedido(Long id, Pedido pedido);

    boolean deletePedido(Long id);

    List<Pedido> findPedidosByStatusPagamento(boolean pago);

    List<Pedido> findPedidosByStatus(StatusPedido status);
    
}
