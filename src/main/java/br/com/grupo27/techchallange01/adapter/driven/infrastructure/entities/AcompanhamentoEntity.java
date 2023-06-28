package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.Acompanhamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ACOMPANHAMENTO")
public class AcompanhamentoEntity extends ProdutoEntity {

    protected AcompanhamentoEntity() {}

    public AcompanhamentoEntity(String nome, String descricao, BigDecimal preco) {}

    public Acompanhamento toAcompanhamento() {
        return new Acompanhamento(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
