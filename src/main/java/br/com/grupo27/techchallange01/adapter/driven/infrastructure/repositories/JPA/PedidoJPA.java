package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.PedidoEntity;
import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;

public interface PedidoJPA extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByPago(boolean pago);

    List<PedidoEntity> findByStatus(StatusPedido status);

}
