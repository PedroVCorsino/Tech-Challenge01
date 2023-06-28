package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.BebidaDTO;

public interface BebidaService {
  
    BebidaDTO getBebidaById(Long id);

    List<BebidaDTO> getAllBebidas();

    BebidaDTO createBebida(BebidaDTO bebidaDTO);

    BebidaDTO updateBebida(Long id, BebidaDTO bebidaDTO);

    boolean deleteBebida(Long id);
}
