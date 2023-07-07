package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.model.Bebida;

public interface BebidaRepositoryPort {
    Bebida saveBebida(Bebida bebida);
    Bebida updateBebida(Long id, Bebida bebida);
    Bebida findBebidaById(Long id);
    boolean deleteBebida(Long id);
    List<Bebida> listAllBebidas();
}
