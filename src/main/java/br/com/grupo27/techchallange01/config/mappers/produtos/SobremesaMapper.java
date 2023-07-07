package br.com.grupo27.techchallange01.config.mappers.produtos;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.SobremesaEntity;
import br.com.grupo27.techchallange01.core.application.dto.SobremesaDTO;
import br.com.grupo27.techchallange01.core.domain.model.Sobremesa;

@Component
public class SobremesaMapper {

    public SobremesaEntity domainToEntity(Sobremesa sobremesa) {
        return new SobremesaEntity(
                sobremesa.getId(),
                sobremesa.getNome(),
                sobremesa.getDescricao(),
                sobremesa.getPreco()
        );
    }

    public Sobremesa dtoToDomain(SobremesaDTO sobremesaDTO) {
        return new Sobremesa(
                sobremesaDTO.id(),
                sobremesaDTO.nome(),
                sobremesaDTO.descricao(),
                sobremesaDTO.preco()
        );
    }

    public SobremesaDTO domainToDto(Sobremesa sobremesa) {
        return new SobremesaDTO(
                sobremesa.getId(),
                sobremesa.getNome(),
                sobremesa.getDescricao(),
                sobremesa.getPreco()
        );
    }

    public Sobremesa entityToDomain(SobremesaEntity sobremesaEntity) {
        return new Sobremesa(
                sobremesaEntity.getId(),
                sobremesaEntity.getNome(),
                sobremesaEntity.getDescricao(),
                sobremesaEntity.getPreco()
        );
    }
}
