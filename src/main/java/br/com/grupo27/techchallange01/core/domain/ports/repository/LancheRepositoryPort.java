package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.model.Lanche;

public interface LancheRepositoryPort {
    Lanche saveLanche(Lanche lanche);
    Lanche updateLanche(Long id, Lanche lanche);
    Lanche findLancheById(Long id);
    boolean deleteLanche(Long id);
    List<Lanche> listAllLanches();
}
