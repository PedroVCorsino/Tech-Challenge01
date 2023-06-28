package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.SobremesaDTO;

public interface SobremesaService {
  
    SobremesaDTO getSobremesaById(Long id);

    List<SobremesaDTO> getAllSobremesas();

    SobremesaDTO createSobremesa(SobremesaDTO sobremesaDTO);

    SobremesaDTO updateSobremesa(Long id, SobremesaDTO sobremesaDTO);

    boolean deleteSobremesa(Long id);
}
