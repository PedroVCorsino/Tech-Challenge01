package br.com.grupo27.techchallange01.core.domain.model;

import java.math.BigDecimal;
import java.util.List;

import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;

public class Pedido {
    private Long id;
    private Long idCliente;
    private List<Combo> combos;
    private BigDecimal valorTotal;
    private StatusPedido status;
    private boolean pago = false;

    public Pedido(Long id, Long idCliente, List<Combo> combos) {
        this.id = id;
        this.idCliente = idCliente;
        this.combos = combos;
        this.valorTotal = calcularValorTotal();
        this.status = StatusPedido.PENDENTE; // ainda não foi pago
        this.pago = false; // Definir o valor inicial desejado para pago
    }

    private BigDecimal calcularValorTotal() {
        return combos.stream()
                .map(Combo::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
        this.valorTotal = calcularValorTotal();
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
