package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;

public record PedidoDTO(
    Long id,
    Long idCliente,
    List<ComboDTO> combos,
    BigDecimal valorTotal,
    StatusPedido status,
    boolean pago
) {

}
