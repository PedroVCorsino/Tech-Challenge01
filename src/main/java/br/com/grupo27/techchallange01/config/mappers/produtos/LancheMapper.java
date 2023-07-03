package br.com.grupo27.techchallange01.config.mappers.produtos;
import org.springframework.stereotype.Component;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.LancheEntity;

import br.com.grupo27.techchallange01.core.application.dto.LancheDTO;
import br.com.grupo27.techchallange01.core.domain.model.Lanche;

@Component
public class LancheMapper {

    public LancheEntity domainToEntity(Lanche lanche) {
        return new LancheEntity(lanche.getId(), lanche.getNome(), lanche.getDescricao(), lanche.getPreco());
    }

    public Lanche dtoToDomain(LancheDTO lancheDTO) {
        return new Lanche(lancheDTO.id(), lancheDTO.nome(), lancheDTO.descricao(), lancheDTO.preco());
    }

    public LancheDTO domainToDto(Lanche lanche) {
        return new LancheDTO(lanche.getId(), lanche.getNome(), lanche.getDescricao(), lanche.getPreco());
    }

    public Lanche entityToDomain(LancheEntity lancheEntity) {
        return new Lanche(lancheEntity.getId(), lancheEntity.getNome(), lancheEntity.getDescricao(), lancheEntity.getPreco());
    }
}