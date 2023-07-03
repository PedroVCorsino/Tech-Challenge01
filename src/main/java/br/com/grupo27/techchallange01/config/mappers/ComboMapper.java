package br.com.grupo27.techchallange01.config.mappers;

import br.com.grupo27.techchallange01.core.domain.model.Combo;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ComboEntity;
import br.com.grupo27.techchallange01.config.mappers.produtos.AcompanhamentoMapper;
import br.com.grupo27.techchallange01.config.mappers.produtos.BebidaMapper;
import br.com.grupo27.techchallange01.config.mappers.produtos.LancheMapper;
import br.com.grupo27.techchallange01.config.mappers.produtos.SobremesaMapper;
import br.com.grupo27.techchallange01.core.application.dto.ComboDTO;

@Component
public class ComboMapper {

    private final LancheMapper lancheMapper;
    private final AcompanhamentoMapper acompanhamentoMapper;
    private final BebidaMapper bebidaMapper;
    private final SobremesaMapper sobremesaMapper;

    public ComboMapper(LancheMapper lancheMapper, AcompanhamentoMapper acompanhamentoMapper, BebidaMapper bebidaMapper, SobremesaMapper sobremesaMapper) {
        this.lancheMapper = lancheMapper;
        this.acompanhamentoMapper = acompanhamentoMapper;
        this.bebidaMapper = bebidaMapper;
        this.sobremesaMapper = sobremesaMapper;
    }
    public ComboEntity domainToEntity(Combo combo) {
        return new ComboEntity(
                combo.getId(),
                lancheMapper.domainToEntity(combo.getLanche()),
                acompanhamentoMapper.domainToEntity(combo.getAcompanhamento()),
                bebidaMapper.domainToEntity(combo.getBebida()),
                sobremesaMapper.domainToEntity(combo.getSobremesa()),
                combo.getQuantidade(),
                combo.getValorUnitario(),
                combo.getValorTotal()
        );
    }

    public Combo dtoToDomain(ComboDTO comboDTO) {
        return new Combo(
                comboDTO.id(),
                lancheMapper.dtoToDomain(comboDTO.lanche()),
                acompanhamentoMapper.dtoToDomain(comboDTO.acompanhamento()),
                bebidaMapper.dtoToDomain(comboDTO.bebida()),
                sobremesaMapper.dtoToDomain(comboDTO.sobremesa()),
                comboDTO.quantidade(),
                comboDTO.valorUnitario(),
                comboDTO.valorTotal()
        );
    }

    public ComboDTO domainToDto(Combo combo) {
        return new ComboDTO(
                combo.getId(),
                lancheMapper.domainToDto(combo.getLanche()),
                acompanhamentoMapper.domainToDto(combo.getAcompanhamento()),
                bebidaMapper.domainToDto(combo.getBebida()),
                sobremesaMapper.domainToDto(combo.getSobremesa()),
                combo.getQuantidade(), 
                combo.getValorUnitario(), combo.getValorTotal()
        );
    }

    public Combo entityToDomain(ComboEntity comboEntity) {
        return new Combo(
                comboEntity.getId(),
                lancheMapper.entityToDomain(comboEntity.getLanche()),
                acompanhamentoMapper.entityToDomain(comboEntity.getAcompanhamento()),
                bebidaMapper.entityToDomain(comboEntity.getBebida()),
                sobremesaMapper.entityToDomain(comboEntity.getSobremesa()),
                comboEntity.getQuantidade(),
                comboEntity.getValorUnitario(),
                comboEntity.getValorTotal()
        );
    }
}

