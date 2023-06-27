package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ItemPedido;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.Produto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("UNICO")
public class ItemPedidoUnico extends ItemPedido {

    @OneToOne
    private Produto produto;

    @Override
    public void updateValor() {
        if (produto != null) {
            setValor(produto.getPreco());
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
