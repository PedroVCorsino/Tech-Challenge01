package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import java.math.BigDecimal;

import br.com.grupo27.techchallange01.core.domain.model.Acompanhamento;
import br.com.grupo27.techchallange01.core.domain.model.Bebida;
import br.com.grupo27.techchallange01.core.domain.model.Lanche;
import br.com.grupo27.techchallange01.core.domain.model.Sobremesa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMBO")
public class ComboEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "lanche_id")
    private LancheEntity lanche;

    @ManyToOne
    @JoinColumn(name = "acompanhamento_id")
    private AcompanhamentoEntity acompanhamento;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private BebidaEntity bebida;

    @ManyToOne
    @JoinColumn(name = "sobremesa_id")
    private SobremesaEntity sobremesa;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;


    public ComboEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LancheEntity getLanche() {
        return lanche;
    }

    public void setLanche(LancheEntity lanche) {
        this.lanche = lanche;
    }

    public AcompanhamentoEntity getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(AcompanhamentoEntity acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public BebidaEntity getBebida() {
        return bebida;
    }

    public void setBebida(BebidaEntity bebida) {
        this.bebida = bebida;
    }

    public SobremesaEntity getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(SobremesaEntity sobremesa) {
        this.sobremesa = sobremesa;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    // @PrePersist
    // @PreUpdate
    // private void calcularValorUnitarioETotal() {
    //     BigDecimal valorLanche = (lanche != null) ? lanche.getPreco() : BigDecimal.ZERO;
    //     BigDecimal valorAcompanhamento = (acompanhamento != null) ? acompanhamento.getPreco() : BigDecimal.ZERO;
    //     BigDecimal valorBebida = (bebida != null) ? bebida.getPreco() : BigDecimal.ZERO;
    //     BigDecimal valorSobremesa = (sobremesa != null) ? sobremesa.getPreco() : BigDecimal.ZERO;

    //     valorUnitario = valorLanche.add(valorAcompanhamento).add(valorBebida).add(valorSobremesa);
    //     valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    // }
}
