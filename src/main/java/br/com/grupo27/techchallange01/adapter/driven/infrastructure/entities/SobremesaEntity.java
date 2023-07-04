package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ProdutoEntity;
import br.com.grupo27.techchallange01.core.domain.model.Sobremesa;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SOBREMESA")
public class SobremesaEntity extends ProdutoEntity {

    protected SobremesaEntity() {}

    public SobremesaEntity(Long id, String nome, String descricao, BigDecimal preco) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    public Sobremesa toSobremesa() {
        return new Sobremesa(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
