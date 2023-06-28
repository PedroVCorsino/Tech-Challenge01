package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.Lanche;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LANCHE")
public class LancheEntity extends ProdutoEntity {

    protected LancheEntity() {}

    public LancheEntity(String nome, String descricao, BigDecimal preco) {}

    public Lanche toLanche() {
        return new Lanche(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

}

