package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.AcompanhamentoDTO;

public interface AcompanhamentoService {
  
    AcompanhamentoDTO getAcompanhamentoById(Long id);

    List<AcompanhamentoDTO> getAllAcompanhamentos();

    AcompanhamentoDTO createAcompanhamento(AcompanhamentoDTO acompanhamentoDTO);

    AcompanhamentoDTO updateAcompanhamento(Long id, AcompanhamentoDTO acompanhamentoDTO);

    boolean deleteAcompanhamento(Long id);
}
