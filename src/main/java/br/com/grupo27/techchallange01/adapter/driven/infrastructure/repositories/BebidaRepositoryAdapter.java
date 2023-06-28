package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.BebidaEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.BebidaRepositoryJPA;
import br.com.grupo27.techchallange01.core.domain.Bebida;
import br.com.grupo27.techchallange01.core.domain.ports.repository.BebidaRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BebidaRepositoryAdapter implements BebidaRepositoryPort {

    private final BebidaRepositoryJPA bebidaRepositoryJPA;

    public BebidaRepositoryAdapter(BebidaRepositoryJPA bebidaRepositoryJPA) {
        this.bebidaRepositoryJPA = bebidaRepositoryJPA;
    }

    @Override
    public Bebida saveBebida(Bebida bebida) {
        BebidaEntity bebidaEntity = new BebidaEntity(bebida.getNome(), bebida.getDescricao(), bebida.getPreco());
        bebidaEntity = bebidaRepositoryJPA.save(bebidaEntity);
        return bebidaEntity.toBebida();
    }

    @Override
    public Bebida updateBebida(Long id, Bebida bebida) {
        return bebidaRepositoryJPA.findById(id).map(bebidaEntity -> {
            bebidaEntity.setNome(bebida.getNome());
            bebidaEntity.setDescricao(bebida.getDescricao());
            bebidaEntity.setPreco(bebida.getPreco());
            bebidaEntity = bebidaRepositoryJPA.save(bebidaEntity);
            return bebidaEntity.toBebida();
        }).orElse(null);
    }

    @Override
    public Bebida findBebidaById(Long id) {
        return bebidaRepositoryJPA.findById(id).map(BebidaEntity::toBebida).orElse(null);
    }

    @Override
    public boolean deleteBebida(Long id) {
        if (bebidaRepositoryJPA.existsById(id)) {
            bebidaRepositoryJPA.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Bebida> listAllBebidas() {
        return bebidaRepositoryJPA.findAll().stream()
                .map(BebidaEntity::toBebida)
                .collect(Collectors.toList());
    }
}
