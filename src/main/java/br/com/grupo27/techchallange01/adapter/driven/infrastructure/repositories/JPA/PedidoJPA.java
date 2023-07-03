package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.PedidoEntity;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;

public interface PedidoJPA extends JpaRepository<PedidoEntity, Long> {}
