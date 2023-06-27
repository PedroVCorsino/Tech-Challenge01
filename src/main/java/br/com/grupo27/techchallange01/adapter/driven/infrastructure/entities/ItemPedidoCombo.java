package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.ItemPedido;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("COMBO")
public class ItemPedidoCombo extends ItemPedido {
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Lanche lanche; 
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Acompanhamento acompanhamento;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Bebida bebida;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Sobremesa sobremesa;     


    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Sobremesa getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(Sobremesa sobremesa) {
        this.sobremesa = sobremesa;
    }

    @Override
    public void updateValor() {
        BigDecimal valor = BigDecimal.ZERO;

        if (lanche != null) {
            valor = valor.add(lanche.getPreco());
        }

        if (acompanhamento != null) {
            valor = valor.add(acompanhamento.getPreco());
        }

        if (bebida != null) {
            valor = valor.add(bebida.getPreco());
        }

        if (sobremesa != null) {
            valor = valor.add(sobremesa.getPreco());
        }

        setValor(valor);
    }
    
}
