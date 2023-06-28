package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.LancheEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.LancheRepositoryJPA;
import br.com.grupo27.techchallange01.core.domain.Lanche;
import br.com.grupo27.techchallange01.core.domain.ports.repository.LancheRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LancheRepositoryAdapter implements LancheRepositoryPort {

    private final LancheRepositoryJPA lancheRepositoryJPA;

    public LancheRepositoryAdapter(LancheRepositoryJPA lancheRepositoryJPA) {
        this.lancheRepositoryJPA = lancheRepositoryJPA;
    }

    @Override
    public Lanche saveLanche(Lanche lanche) {
        LancheEntity lancheEntity = new LancheEntity(lanche.getNome(), lanche.getDescricao(), lanche.getPreco());
        lancheEntity = lancheRepositoryJPA.save(lancheEntity);
        return lancheEntity.toLanche();
    }

    @Override
    public Lanche updateLanche(Long id, Lanche lanche) {
        return lancheRepositoryJPA.findById(id).map(lancheEntity -> {
            lancheEntity.setNome(lanche.getNome());
            lancheEntity.setDescricao(lanche.getDescricao());
            lancheEntity.setPreco(lanche.getPreco());
            lancheEntity = lancheRepositoryJPA.save(lancheEntity);
            return lancheEntity.toLanche();
        }).orElse(null);
    }

    @Override
    public Lanche findLancheById(Long id) {
        return lancheRepositoryJPA.findById(id).map(LancheEntity::toLanche).orElse(null);
    }

    @Override
    public boolean deleteLanche(Long id) {
        if (lancheRepositoryJPA.existsById(id)) {
            lancheRepositoryJPA.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Lanche> listAllLanches() {
        return lancheRepositoryJPA.findAll().stream()
                .map(LancheEntity::toLanche)
                .collect(Collectors.toList());
    }
}
