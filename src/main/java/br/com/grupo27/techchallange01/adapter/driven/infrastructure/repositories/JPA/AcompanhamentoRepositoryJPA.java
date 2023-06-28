package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.AcompanhamentoEntity;

public interface AcompanhamentoRepositoryJPA extends JpaRepository<AcompanhamentoEntity, Long> {}
