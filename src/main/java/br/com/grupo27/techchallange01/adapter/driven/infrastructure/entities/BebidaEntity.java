package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.model.Bebida;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BEBIDA")
public class BebidaEntity extends ProdutoEntity {

    protected BebidaEntity() {}

    public BebidaEntity(String nome, String descricao, BigDecimal preco) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    public Bebida toBebida() {
        return new Bebida(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
