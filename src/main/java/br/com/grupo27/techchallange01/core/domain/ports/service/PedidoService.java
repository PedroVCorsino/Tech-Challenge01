package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.PedidoDTO;
import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;

public interface PedidoService {

    PedidoDTO getPedidoById(Long id);

    List<PedidoDTO> getAllPedidos();

    PedidoDTO createPedido(PedidoDTO pedidoDTO);

    PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO);

    boolean deletePedido(Long id);

    boolean consultaStatusPagamento(Long id);

    PedidoDTO verificaStatusPagamento(Long id);

    List<PedidoDTO> findPedidosByStatusPagamento(boolean pago);

    List<Pedido> findPedidosByStatus(StatusPedido status);
    
}
