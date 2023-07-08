package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ClienteEntity;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public interface ClienteJPA extends JpaRepository<ClienteEntity, Long> {
    @Query(value = "SELECT * FROM clientes c WHERE c.name LIKE %:name%", nativeQuery = true)
    List<ClienteEntity> findByName(@Param("name") String name);

    Optional<ClienteEntity> findByCpf(ValidadorCPF cpf);
}
