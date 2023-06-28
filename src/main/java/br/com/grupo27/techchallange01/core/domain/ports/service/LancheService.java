package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.LancheDTO;

public interface LancheService {
  
    LancheDTO getLancheById(Long id);

    List<LancheDTO> getAllLanches();

    LancheDTO createLanche(LancheDTO lancheDTO);

    LancheDTO updateLanche(Long id, LancheDTO lancheDTO);

    boolean deleteLanche(Long id);

}

