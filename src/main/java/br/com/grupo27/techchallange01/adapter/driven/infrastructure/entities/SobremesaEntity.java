package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.Sobremesa;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOBREMESA")
public class SobremesaEntity extends ProdutoEntity {

    protected SobremesaEntity() {}

    public SobremesaEntity(String nome, String descricao, BigDecimal preco) {}

    public Sobremesa toSobremesa() {
        return new Sobremesa(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
