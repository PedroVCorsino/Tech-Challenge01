package br.com.grupo27.techchallange01.config.mappers;

import br.com.grupo27.techchallange01.core.domain.model.Combo;
import br.com.grupo27.techchallange01.core.application.dto.ComboDTO;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ComboEntity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class ComboMapper {

    // private final LancheMapper lancheMapper;
    // private final AcompanhamentoMapper acompanhamentoMapper;
    // private final BebidaMapper bebidaMapper;
    // private final SobremesaMapper sobremesaMapper;

    // public ComboMapper(LancheMapper lancheMapper, AcompanhamentoMapper acompanhamentoMapper,
    //                    BebidaMapper bebidaMapper, SobremesaMapper sobremesaMapper) {
    //     this.lancheMapper = lancheMapper;
    //     this.acompanhamentoMapper = acompanhamentoMapper;
    //     this.bebidaMapper = bebidaMapper;
    //     this.sobremesaMapper = sobremesaMapper;
    // }
    public ComboMapper(){}

    public ComboEntity domainToEntity(Combo combo) {
        if (combo == null) {
            return null;
        }

        ComboEntity comboEntity = new ComboEntity();
        comboEntity.setId(combo.getId());
        comboEntity.setLanche(combo.getLanche().toEntity());
        comboEntity.setAcompanhamento(combo.getAcompanhamento().toEntity());
        comboEntity.setBebida(combo.getBebida().toEntity());
        comboEntity.setSobremesa(combo.getSobremesa().toEntity());
        comboEntity.setQuantidade(combo.getQuantidade());
        comboEntity.setValorUnitario(combo.getValorUnitario());
        comboEntity.setValorTotal(combo.getValorTotal());

        return comboEntity;
    }

    public Combo dtoToDomain(ComboDTO comboDTO) {
            if(comboDTO == null) {
                return null;
            }

            Combo combo = new Combo();
            combo.setLanche(comboDTO.lanche().toLanche());
            combo.setAcompanhamento(comboDTO.acompanhamento().toAcompanhamento());
            combo.setBebida(comboDTO.bebida().toBebida());
            combo.setSobremesa(comboDTO.sobremesa().toSobremesa());
            combo.setQuantidade(comboDTO.quantidade());
            combo.setValorUnitario(comboDTO.valorUnitario());
            combo.setValorTotal(comboDTO.valorTotal());

            return combo;
        }

    public ComboDTO domainToDto(Combo combo) {
        if (combo == null) {
            return null;
        }

        ComboDTO comboDTO = new ComboDTO(combo.getId(), 
            combo.getLanche().toDTO(), 
            combo.getAcompanhamento().toDTO(),
            combo.getBebida().toDTO(),
            combo.getSobremesa().toDTO(),
            combo.getQuantidade(),
            combo.getValorUnitario(),
            combo.getValorTotal());

        return comboDTO;
    }

    public Combo entityToDomain(ComboEntity comboEntity) {
        if (comboEntity == null) {
            return null;
        }

        Combo combo = new Combo();
        combo.setId(comboEntity.getId());
        combo.setLanche(comboEntity.getLanche().toLanche());
        combo.setAcompanhamento(comboEntity.getAcompanhamento().toAcompanhamento());
        combo.setBebida(comboEntity.getBebida().toBebida());
        combo.setSobremesa(comboEntity.getSobremesa().toSobremesa());
        combo.setQuantidade(comboEntity.getQuantidade());
        combo.setValorUnitario(comboEntity.getValorUnitario());
        combo.setValorTotal(comboEntity.getValorTotal());

        return combo;
    }
}
