package br.com.grupo27.techchallange01.core.application.dto;

import java.math.BigDecimal;


public record ComboDTO(
    Long id,
    LancheDTO lanche,
    AcompanhamentoDTO acompanhamento,
    BebidaDTO bebida,
    SobremesaDTO sobremesa,
    Integer quantidade,
    BigDecimal valorUnitario,
    BigDecimal valorTotal
) {}
