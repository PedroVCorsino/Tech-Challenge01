package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ClienteEntity;

public interface ClienteJPA extends JpaRepository<ClienteEntity, Long> {
    @Query(value = "SELECT * FROM clientes c WHERE c.name LIKE %:name%", nativeQuery = true)
    List<ClienteEntity> findByName(@Param("name") String name);
}
