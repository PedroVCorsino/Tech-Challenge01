package br.com.grupo27.techchallange01.config.mappers.produtos;
import org.springframework.stereotype.Component;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.LancheEntity;

import br.com.grupo27.techchallange01.core.application.dto.LancheDTO;
import br.com.grupo27.techchallange01.core.domain.model.Lanche;

@Component
public class LancheMapper {

    public LancheEntity domainToEntity(Lanche lanche) {
        if(lanche == null) {
            return null;
        }
        LancheEntity lancheE = new LancheEntity(lanche.getId(), lanche.getNome(), lanche.getDescricao(), lanche.getPreco());
        return lancheE;
    }

    public Lanche dtoToDomain(LancheDTO lancheDTO) {
        if(lancheDTO == null) {
            return null;
        }
        return new Lanche(lancheDTO.id(), lancheDTO.nome(), lancheDTO.descricao(), lancheDTO.preco());
    }

    public LancheDTO domainToDto(Lanche lanche) {
        if(lanche == null) {
            return null;
        }
        return new LancheDTO(lanche.getId(), lanche.getNome(), lanche.getDescricao(), lanche.getPreco());
    }

    public Lanche entityToDomain(LancheEntity lancheEntity) {
        if(lancheEntity == null) {
            return null;
        }
        return new Lanche(lancheEntity.getId(), lancheEntity.getNome(), lancheEntity.getDescricao(), lancheEntity.getPreco());
    }
}
