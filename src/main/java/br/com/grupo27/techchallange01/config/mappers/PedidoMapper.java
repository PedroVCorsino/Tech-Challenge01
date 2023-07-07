package br.com.grupo27.techchallange01.config.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ComboEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.PedidoEntity;
import br.com.grupo27.techchallange01.core.application.dto.ComboDTO;
import br.com.grupo27.techchallange01.core.application.dto.PedidoDTO;
import br.com.grupo27.techchallange01.core.domain.model.Combo;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;

@Component
public class PedidoMapper {
    
    private final ComboMapper comboMapper;

    public PedidoMapper(ComboMapper comboMapper) {
        this.comboMapper = comboMapper;
    }

    public PedidoEntity domainToEntity(Pedido pedido) {
        List<ComboEntity> comboEntities = pedido.getCombos().stream()
                .map(comboMapper::domainToEntity)
                .collect(Collectors.toList());

        comboEntities.size();

        return new PedidoEntity(
                pedido.getId(),
                pedido.getIdCliente(),
                comboEntities,
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.isPago()
        );
    }

    public PedidoDTO domainToDto(Pedido pedido) {
        List<ComboDTO> comboDTOs = pedido.getCombos().stream()
                .map(comboMapper::domainToDto)
                .collect(Collectors.toList());

        return new PedidoDTO(
                pedido.getId(),
                pedido.getIdCliente(),
                comboDTOs,
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.isPago()
        );
    }

    public Pedido dtoToDomain(PedidoDTO pedidoDTO) {
        List<Combo> combos = pedidoDTO.combos().stream()
                .map(comboMapper::dtoToDomain)
                .collect(Collectors.toList());
        
                combos.size();

        return new Pedido(
                pedidoDTO.id(),
                pedidoDTO.idCliente(),
                combos,
                pedidoDTO.valorTotal(),
                pedidoDTO.status(),
                pedidoDTO.pago()
        );
    }

    public Pedido entityToDomain(PedidoEntity pedidoEntity) {
        List<Combo> combos = pedidoEntity.getCombos().stream()
                .map(comboMapper::entityToDomain)
                .collect(Collectors.toList());

        return new Pedido(
                pedidoEntity.getId(),
                pedidoEntity.getIdCliente(),
                combos,
                pedidoEntity.getValorTotal(),
                pedidoEntity.getStatus(),
                pedidoEntity.isPago()
        );
    }
}
