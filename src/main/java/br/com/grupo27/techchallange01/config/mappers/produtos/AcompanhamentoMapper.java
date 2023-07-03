package br.com.grupo27.techchallange01.config.mappers.produtos;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.AcompanhamentoEntity;

import br.com.grupo27.techchallange01.core.application.dto.AcompanhamentoDTO;
import br.com.grupo27.techchallange01.core.domain.model.Acompanhamento;

@Component
public class AcompanhamentoMapper {

    public AcompanhamentoEntity domainToEntity(Acompanhamento acompanhamento) {
        return new AcompanhamentoEntity(
                acompanhamento.getId(),
                acompanhamento.getNome(),
                acompanhamento.getDescricao(),
                acompanhamento.getPreco()
        );
    }

    public Acompanhamento dtoToDomain(AcompanhamentoDTO acompanhamentoDTO) {
        return new Acompanhamento(
                acompanhamentoDTO.id(),
                acompanhamentoDTO.nome(),
                acompanhamentoDTO.descricao(),
                acompanhamentoDTO.preco()
        );
    }

    public AcompanhamentoDTO domainToDto(Acompanhamento acompanhamento) {
        return new AcompanhamentoDTO(
                acompanhamento.getId(),
                acompanhamento.getNome(),
                acompanhamento.getDescricao(),
                acompanhamento.getPreco()
        );
    }

    public Acompanhamento entityToDomain(AcompanhamentoEntity acompanhamentoEntity) {
        return new Acompanhamento(
                acompanhamentoEntity.getId(),
                acompanhamentoEntity.getNome(),
                acompanhamentoEntity.getDescricao(),
                acompanhamentoEntity.getPreco()
        );
    }
}
