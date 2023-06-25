package br.com.grupo27.techchallange01.core.application.dto;

import br.com.grupo27.techchallange01.core.domain.Enums.StatusPedido;
import br.com.grupo27.techchallange01.core.domain.entities.abstractions.ItemPedido;

import java.util.List;

public record PedidoDTO(
    Long id,
    ClienteDTO cliente,
    List<ItemPedido> itens,
    StatusPedido status
) {
    
}
