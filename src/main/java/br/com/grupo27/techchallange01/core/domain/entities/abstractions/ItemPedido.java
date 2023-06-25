package br.com.grupo27.techchallange01.core.domain.entities.abstractions;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.entities.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEM_PEDIDO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_item")
public abstract class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
        updateTotal();
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        updateTotal();
    }
    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void updateValor();

    public void updateTotal() {
        updateValor();
        if (getValor() != null && getQuantidade() != null) {
            BigDecimal total = getValor().multiply(BigDecimal.valueOf(getQuantidade()));
            setTotal(total);
        }
    }

}
