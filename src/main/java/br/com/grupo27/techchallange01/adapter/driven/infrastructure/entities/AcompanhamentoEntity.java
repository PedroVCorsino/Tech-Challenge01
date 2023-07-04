package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.model.Acompanhamento;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACOMPANHAMENTO")
public class AcompanhamentoEntity extends ProdutoEntity {

    protected AcompanhamentoEntity() {}

    public AcompanhamentoEntity(Long id, String nome, String descricao, BigDecimal preco) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    public Acompanhamento toAcompanhamento() {
        return new Acompanhamento(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
