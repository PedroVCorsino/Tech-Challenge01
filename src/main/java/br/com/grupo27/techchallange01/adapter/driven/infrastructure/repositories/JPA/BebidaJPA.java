package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.BebidaEntity;

public interface BebidaJPA extends JpaRepository<BebidaEntity, Long> {}
