package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.model.Bebida;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BEBIDA")
public class BebidaEntity extends ProdutoEntity {

    protected BebidaEntity() {}

    public BebidaEntity(Long id, String nome, String descricao, BigDecimal preco) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    public Bebida toBebida() {
        return new Bebida(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
